package pl.dudi.productionservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.dudi.basedomains.dto.PageRequestDto;
import pl.dudi.basedomains.utils.PageableService;
import pl.dudi.productionservice.dto.OpinionRequestDto;
import pl.dudi.productionservice.dto.OpinionResponse;
import pl.dudi.productionservice.infrastructure.database.dao.OpinionDao;
import pl.dudi.productionservice.infrastructure.database.dao.ProductDao;
import pl.dudi.productionservice.model.Opinion;
import pl.dudi.productionservice.model.Product;
import pl.dudi.productionservice.service.OpinionService;

import java.time.OffsetDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class OpinionServiceImpl implements OpinionService {

    public static final PageRequestDto DEFAULT_OPINION_REQUEST = new PageRequestDto(1, 10, "desc", "issuedAt");

    private final OpinionDao opinionDao;
    private final ProductDao productDao;
    private final PageableService pageableService;
    @Override
    public String submitOpinion(OpinionRequestDto opinionRequest) {
        Product product = productDao.findByProductCode(opinionRequest.productNumber());
        Opinion opinion = opinionDao.saveOpinion( buildOpinion(product, opinionRequest));
        return "Opinion submitted to product: [%s]".formatted(product.getProductName());
    }

    @Override
    public Page<OpinionResponse> getOpinions(String productCode, PageRequestDto pageRequestDto) {
        Pageable pageable = pageableService.preparePageable(DEFAULT_OPINION_REQUEST, pageRequestDto);
        Page<Opinion> opinions = opinionDao.findOpinions(productCode, pageable);
        return opinions.map(
            o-> new OpinionResponse(o.score(),o.comment(),o.issuedAt())
        );
    }

    @Override
    public Page<OpinionResponse> getOpinionsByScore(String productCode, int score, PageRequestDto pageRequestDto) {
        Pageable pageable = pageableService.preparePageable(DEFAULT_OPINION_REQUEST, pageRequestDto);
        Page<Opinion> opinions = opinionDao.findOpinionsByScore(productCode, score, pageable);
        return opinions.map(
            o-> new OpinionResponse(o.score(),o.comment(),o.issuedAt())
        );
    }

    private Opinion buildOpinion(Product product, OpinionRequestDto opinionRequest) {
        return new Opinion(
            opinionRequest.description(),
            opinionRequest.score(),
            OffsetDateTime.now(),
            product
        );
    }
}
