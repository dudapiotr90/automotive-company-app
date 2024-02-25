package pl.dudi.productionservice.service;

import org.springframework.data.domain.Page;
import pl.dudi.basedomains.dto.PageRequestDto;
import pl.dudi.productionservice.dto.OpinionRequestDto;
import pl.dudi.productionservice.dto.OpinionResponse;
import pl.dudi.productionservice.model.Opinion;

public interface OpinionService {
    String submitOpinion(OpinionRequestDto opinionRequest);

    Page<OpinionResponse> getOpinions(String productCode, PageRequestDto pageRequestDto);

    Page<OpinionResponse> getOpinionsByScore(String productCode, int score, PageRequestDto pageRequestDto);
}
