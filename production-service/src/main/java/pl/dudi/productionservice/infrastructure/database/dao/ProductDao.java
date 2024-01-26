package pl.dudi.productionservice.infrastructure.database.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.dudi.productionservice.infrastructure.database.entity.ProductEntity;
import pl.dudi.productionservice.model.Product;

import java.util.Set;

public interface ProductDao {
    Page<Product> findProducts(Pageable pageable);

    Product findByProductNumber(String productNumber);

    Product saveProduct(Product product);

    Set<Product> saveProducts(Set<Product> products);
}
