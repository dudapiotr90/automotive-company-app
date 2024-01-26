package pl.dudi.productionservice.infrastructure.database.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import pl.dudi.productionservice.infrastructure.database.dao.ProductDao;
import pl.dudi.productionservice.infrastructure.database.repository.jpa.ProductJpaRepository;
import pl.dudi.productionservice.mappers.ProductMapper;
import pl.dudi.productionservice.model.Product;

@Repository
@RequiredArgsConstructor
public class ProductRepository implements ProductDao {

    private final ProductJpaRepository productJpaRepository;
    private final ProductMapper productMapper;

    @Override
    public Page<Product> findProducts(Pageable pageable) {
        return productJpaRepository.findAll(pageable).map(productMapper::mapToProduct);
    }
}
