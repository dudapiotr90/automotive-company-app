package pl.dudi.customerservice.service;

import org.springframework.data.domain.Page;
import pl.dudi.customerservice.dto.request.OpinionDto;

public interface ProductService {
    String submitOpinion(String productNumber, OpinionDto opinion);

    Page<OpinionDto> getProductOpinions(String productCode, Integer pageNumber, Integer pageSize, String sortHow, String... sortBy);

    Page<OpinionDto> getProductOpinionsByScore(
        String productCode,
        Integer score,
        Integer pageNumber,
        Integer pageSize,
        String sortHow,
        String... sortBy
    );
}
