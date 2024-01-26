package pl.dudi.productionservice.infrastructure.database.repository.jpa;

import com.netflix.appinfo.ApplicationInfoManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dudi.productionservice.infrastructure.database.entity.ProductEntity;

import java.util.Optional;

@Repository
public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {
    Optional<ProductEntity> findByProductNumber(String productNumber);
}
