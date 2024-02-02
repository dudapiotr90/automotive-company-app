package pl.dudi.productionservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.dudi.basedomains.dto.PageRequestDto;
import pl.dudi.basedomains.dto.products.ProductDto;
import pl.dudi.basedomains.dto.products.ProductsDto;
import pl.dudi.basedomains.utils.PageableService;
import pl.dudi.productionservice.infrastructure.database.dao.ProductDao;
import pl.dudi.productionservice.mappers.ProductMapper;
import pl.dudi.productionservice.model.Product;
import pl.dudi.productionservice.service.ProductService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    public static final PageRequestDto DEFAULT_PRODUCT_SEARCH = new PageRequestDto(1, 20, "desc", "popularity");
    private final ProductDao productDao;
    private final PageableService pageableService;
    private final ProductMapper productMapper;
    @Override
    public String addProduct(ProductDto productDto) {
        Product product = createProductDetails(productDto);
        Product saved = productDao.saveProduct(product);
        return saved.getProductNumber();
    }

    @Override
    public Set<String> addProducts(ProductsDto productsDto) {
        Set<Product> products = productsDto.getProducts().stream()
            .map(this::createProductDetails)
            .collect(Collectors.toSet());
        Set<Product> savedProducts = productDao.saveProducts(products);
        return savedProducts.stream()
            .map(Product::getProductNumber)
            .collect(Collectors.toSet());
    }

    @Override
    public ProductDto getProduct(String productNumber) {
        Product product = productDao.findByProductNumber(productNumber);
        return productMapper.mapToProductDto(product);
    }

    @Override
    public Page<ProductDto> getProducts(Integer pageNumber, Integer pageSize, String sortHow, String... sortBy) {
        PageRequestDto pageRequestDto = new PageRequestDto(pageNumber, pageSize, sortHow, sortBy);
        Pageable pageable = pageableService.preparePageable(DEFAULT_PRODUCT_SEARCH, pageRequestDto);
        Page<Product> products = productDao.findProducts(pageable);
        return products.map(productMapper::mapToProductDto);
    }

    private Product createProductDetails(ProductDto productDto) {
        return Product.builder()
            .productNumber(productDto.getProductNumber())
            .available(false)
            .inProduction(false)
            .description(productDto.getDescription())
            .creationDate(productDto.getCreationDate())
            .designerCode(productDto.getDesignerCode())
            .build();
    }
}
