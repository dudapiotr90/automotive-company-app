package pl.dudi.productionservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.dudi.productionservice.dto.OpinionRequestDto;
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

    private final OpinionDao opinionDao;
    private final ProductDao productDao;
    @Override
    public String submitOpinion(OpinionRequestDto opinionRequest) {
        Product product = productDao.findByProductCode(opinionRequest.productNumber());
        Opinion opinion = opinionDao.saveOpinion( buildOpinion(product, opinionRequest));
        return "Opinion submitted to product: [%s]".formatted(product.getProductName());
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
