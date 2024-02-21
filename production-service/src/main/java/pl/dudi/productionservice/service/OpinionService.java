package pl.dudi.productionservice.service;

import pl.dudi.productionservice.dto.OpinionRequestDto;
import pl.dudi.productionservice.model.Opinion;

public interface OpinionService {
    String submitOpinion(OpinionRequestDto opinionRequest);

}
