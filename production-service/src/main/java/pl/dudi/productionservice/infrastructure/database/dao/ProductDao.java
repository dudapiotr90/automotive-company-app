package pl.dudi.productionservice.infrastructure.database.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.dudi.productionservice.model.Product;

public interface ProductDao {
    Page<Product> findProducts(Pageable pageable);
}
