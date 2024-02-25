package pl.dudi.productionservice.infrastructure.database.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.dudi.productionservice.model.Opinion;

public interface OpinionDao {
    Opinion saveOpinion(Opinion opinion);

    Page<Opinion> findOpinions(String productCode, Pageable pageable);

    Page<Opinion> findOpinionsByScore(String productCode, int score, Pageable pageable);
}
