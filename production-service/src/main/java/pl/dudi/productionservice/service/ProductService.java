package pl.dudi.productionservice.service;

import org.springframework.data.domain.Page;
import pl.dudi.basedomains.dto.ProductDto;
import pl.dudi.basedomains.dto.ProductsDto;

import java.util.Set;

public interface ProductService {


    String addProduct(ProductDto productDto);
    Set<String> addProducts(ProductsDto productsDto);

    ProductDto getProduct(String productNumber);

    Page<ProductDto> getProducts(Integer pageNumber, Integer pageSize, String sortHow, String... sortBy);
}
