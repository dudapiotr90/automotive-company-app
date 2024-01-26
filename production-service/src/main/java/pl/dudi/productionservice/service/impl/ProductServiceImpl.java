package pl.dudi.productionservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.dudi.basedomains.dto.PageRequestDto;
import pl.dudi.basedomains.dto.ProductDto;
import pl.dudi.basedomains.dto.ProductsDto;
import pl.dudi.basedomains.utils.PageableService;
import pl.dudi.productionservice.infrastructure.database.dao.ProductDao;
import pl.dudi.productionservice.infrastructure.database.entity.ProductEntity;
import pl.dudi.productionservice.mappers.ProductMapper;
import pl.dudi.productionservice.model.Product;
import pl.dudi.productionservice.service.ProductService;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    public static final PageRequestDto DEFAULT_PRODUCT_SEARCH = new PageRequestDto(1, 20, "desc", "popularity");
    private final ProductDao productDao;
    private final PageableService pageableService;
    private final ProductMapper productMapper;
    @Override
    public String addProduct(ProductDto productDto) {
        return null;
    }

    @Override
    public Set<String> addProducts(ProductsDto productsDto) {
        return null;
    }

    @Override
    public ProductDto getProduct(String productNumber) {
        return null;
    }

    @Override
    public Page<ProductDto> getProducts(Integer pageNumber, Integer pageSize, String sortHow, String... sortBy) {
        PageRequestDto pageRequestDto = new PageRequestDto(pageNumber, pageSize, sortHow, sortBy);
        Pageable pageable = pageableService.preparePageable(DEFAULT_PRODUCT_SEARCH, pageRequestDto);
        Page<Product> products = productDao.findProducts(pageable);
        return products.map(productMapper::mapToProductDto);
    }
}
