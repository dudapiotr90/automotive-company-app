package pl.dudi.productionservice.infrastructure.database.repository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import pl.dudi.productionservice.infrastructure.database.dao.ProductDao;
import pl.dudi.productionservice.infrastructure.database.entity.ProductEntity;
import pl.dudi.productionservice.infrastructure.database.repository.jpa.ProductJpaRepository;
import pl.dudi.productionservice.mappers.ProductMapper;
import pl.dudi.productionservice.model.Product;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ProductRepository implements ProductDao {

    private final ProductJpaRepository productJpaRepository;
    private final ProductMapper productMapper;

    @Override
    public Product saveProduct(Product product) {
        ProductEntity productEntity = productMapper.mapToProductEntity(product);
        ProductEntity saved = productJpaRepository.save(productEntity);
        return productMapper.mapToProduct(saved);
    }

    @Override
    public Set<Product> saveProducts(Set<Product> products) {
        Set<ProductEntity> productEntities = products.stream()
            .map(productMapper::mapToProductEntity)
            .collect(Collectors.toSet());

        List<ProductEntity> productsSaved = productJpaRepository.saveAll(productEntities);

        return productsSaved.stream()
            .map(productMapper::mapToProduct)
            .collect(Collectors.toSet());

    }

    @Override
    public Page<Product> findProducts(Pageable pageable) {
        return productJpaRepository.findAll(pageable).map(productMapper::mapToProduct);
    }

    @Override
    public Product findByProductCode(String productCode) {
        return productJpaRepository.findByProductCode(productCode)
            .map(productMapper::mapToProduct)
            .orElseThrow(() -> new EntityNotFoundException(String.format("Product %s doesn't exist",productCode)));
    }
}
