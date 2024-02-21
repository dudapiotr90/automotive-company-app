package pl.dudi.customerservice.controller;

import lombok.RequiredArgsConstructor;
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

    // TODO to implement
    @GetMapping("/opinion")
    public void getProductOpinions() {

    }

    @GetMapping("/opinion/{score}")
    public void getProductOpinion(
        @PathVariable(name = "score") Integer score
    ) {

    }


    @PostMapping("/{productNumber}/opinion")
    public ResponseEntity<String> submitOpinion(
        @PathVariable(name = "productNumber") String productNumber,
        @RequestBody OpinionDto opinion
    ) {
        String confirmationMessage  = productService.submitOpinion(productNumber, opinion);
        return ResponseEntity.status(HttpStatus.CREATED).body(confirmationMessage);
    }



}
