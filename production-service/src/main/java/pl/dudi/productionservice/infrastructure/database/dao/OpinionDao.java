package pl.dudi.productionservice.infrastructure.database.dao;

import pl.dudi.productionservice.model.Opinion;

public interface OpinionDao {
    Opinion saveOpinion(Opinion opinion);
}
