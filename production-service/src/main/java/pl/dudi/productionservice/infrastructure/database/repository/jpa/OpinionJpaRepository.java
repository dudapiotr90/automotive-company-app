package pl.dudi.productionservice.infrastructure.database.repository.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dudi.productionservice.infrastructure.database.entity.OpinionEntity;

@Repository
public interface OpinionJpaRepository extends JpaRepository<OpinionEntity,Long> {
    Page<OpinionEntity> findByProductCode(String productCode, Pageable pageable);

    Page<OpinionEntity> findByProductCodeAndScore(String productCode, int score, Pageable pageable);
}
