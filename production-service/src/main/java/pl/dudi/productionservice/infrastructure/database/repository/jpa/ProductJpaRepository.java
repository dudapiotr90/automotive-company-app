package pl.dudi.productionservice.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dudi.productionservice.infrastructure.database.entity.ProductEntity;

@Repository
public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {
}
