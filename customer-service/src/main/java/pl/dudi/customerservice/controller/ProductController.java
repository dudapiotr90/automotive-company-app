package pl.dudi.customerservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dudi.customerservice.dto.OpinionDto;
import pl.dudi.customerservice.service.ProductService;

@RestController
@RequestMapping("/customer/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{productCode}/opinion")
    public ResponseEntity<Page<OpinionDto>> getAllProductOpinions(
        @PathVariable(name = "productCode") String productCode,
        @RequestParam(required = false, name = "pageNumber") Integer pageNumber,
        @RequestParam(required = false, name = "pageSize") Integer pageSize,
        @RequestParam(required = false, name = "sortHow") String sortHow,
        @RequestParam(required = false, name = "sortBy") String... sortBy
    ) {
        Page<OpinionDto> productOpinions = productService.getProductOpinions(productCode, pageNumber, pageSize, sortHow, sortBy);
        return ResponseEntity.ok(productOpinions);
    }

    @GetMapping("/{productCode}/opinion/{score}")
    public ResponseEntity<Page<OpinionDto>> getProductOpinionsByScore(
        @PathVariable(name = "productCode") String productCode,
        @PathVariable(name = "score") Integer score,
        @RequestParam(required = false, name = "pageNumber") Integer pageNumber,
        @RequestParam(required = false, name = "pageSize") Integer pageSize,
        @RequestParam(required = false, name = "sortHow") String sortHow,
        @RequestParam(required = false, name = "sortBy") String... sortBy
    ) {
        Page<OpinionDto> opinions = productService.getProductOpinionsByScore(productCode, score, pageNumber, pageSize, sortHow, sortBy);
        return ResponseEntity.ok(opinions);
    }


    @PostMapping("/{productCode}/opinion")
    public ResponseEntity<String> submitOpinion(
        @PathVariable(name = "productCode") String productCode,
        @RequestBody OpinionDto opinion
    ) {
        String confirmationMessage  = productService.submitOpinion(productCode, opinion); // TODO opinion can be edited or submitted only once
        return ResponseEntity.status(HttpStatus.CREATED).body(confirmationMessage);
    }




}
