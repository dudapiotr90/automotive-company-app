package pl.dudi.productionservice.infrastructure.database.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import pl.dudi.productionservice.infrastructure.database.dao.OpinionDao;
import pl.dudi.productionservice.infrastructure.database.entity.OpinionEntity;
import pl.dudi.productionservice.infrastructure.database.repository.jpa.OpinionJpaRepository;
import pl.dudi.productionservice.mappers.OpinionMapper;
import pl.dudi.productionservice.model.Opinion;

@Slf4j
@Repository
@RequiredArgsConstructor
public class OpinionRepository implements OpinionDao {

    private final OpinionJpaRepository opinionJpaRepository;
    private final OpinionMapper opinionMapper;
    @Override
    public Opinion saveOpinion(Opinion opinion) {
        OpinionEntity toSave = opinionMapper.mapToEntity(opinion);
        OpinionEntity saved = opinionJpaRepository.save(toSave);
        return opinionMapper.mapFromEntity(saved);
    }

    @Override
    public Page<Opinion> findOpinions(String productCode, Pageable pageable) {
        Page<OpinionEntity> opinions = opinionJpaRepository.findByProductCode(productCode,pageable);
        return opinions.map(opinionMapper::mapFromEntity);
    }

    @Override
    public Page<Opinion> findOpinionsByScore(String productCode, int score, Pageable pageable) {
        Page<OpinionEntity> opinions = opinionJpaRepository.findByProductCodeAndScore(productCode, score, pageable);
        return opinions.map(opinionMapper::mapFromEntity);
    }

}
