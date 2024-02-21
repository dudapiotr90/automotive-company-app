package pl.dudi.productionservice.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.dudi.basedomains.dto.products.ProductDto;
import pl.dudi.basedomains.dto.products.ProductsDto;
import pl.dudi.productionservice.service.ProductService;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;


    @PostMapping
    @PreAuthorize("hasRole('DESIGNER') || hasRole('MANAGER')")
    public ResponseEntity<String> addProductToCatalog(
        @RequestBody ProductDto productDto
    ) {
        String productNumber = productService.addProduct(productDto);
        return new ResponseEntity<>(productNumber, HttpStatus.CREATED);
    }

    @PostMapping("/all")
    @PreAuthorize("hasRole('DESIGNER') || hasRole('MANAGER')")
    public ResponseEntity<Set<String>> addProductsToCatalog(
        @RequestBody ProductsDto productsDto
    ) {
        Set<String> productNumbers = productService.addProducts(productsDto);
        return new ResponseEntity<>(productNumbers, HttpStatus.CREATED);
    }

    @GetMapping("/{productNumber}")
    public ResponseEntity<ProductDto> getProduct(
        @PathVariable(name = "productCode") String productNumber
    ) {
        ProductDto product = productService.getProduct(productNumber);
        return ResponseEntity.ok(product);
    }
    @GetMapping("/all")
    public ResponseEntity<Page<ProductDto>> getProducts(
        @RequestParam(required = false, name = "pageNumber") Integer pageNumber,
        @RequestParam(required = false, name = "pageSize") Integer pageSize,
        @RequestParam(required = false, name = "sortHow") String sortHow,
        @RequestParam(required = false, name = "sortBy") String sortBy
    ) {
        Page<ProductDto> products = productService.getProducts(pageNumber,pageSize,sortHow,sortBy);
        return ResponseEntity.ok(products);
    }
}
