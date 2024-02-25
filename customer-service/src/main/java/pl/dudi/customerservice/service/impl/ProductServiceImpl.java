package pl.dudi.customerservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import pl.dudi.basedomains.dto.PageRequestDto;
import pl.dudi.basedomains.utils.PageableService;
import pl.dudi.customerservice.dto.OpinionDto;
import pl.dudi.customerservice.model.OpinionRequest;
import pl.dudi.customerservice.service.ProductService;
import pl.dudi.customerservice.service.apiclient.ProductServiceAPIClient;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductServiceAPIClient productServiceAPIClient;


    @Override
    public String submitOpinion(String productNumber, OpinionDto opinion) {
        OpinionRequest opinionRequest = new OpinionRequest(productNumber, opinion.score(), opinion.description());
        return productServiceAPIClient.submitOpinion(opinionRequest);
    }

    @Override
    public Page<OpinionDto> getProductOpinions(String productCode, Integer pageNumber, Integer pageSize, String sortHow, String... sortBy) {
        PageRequestDto pageRequestDto = new PageRequestDto(pageNumber, pageSize, sortHow, sortBy);
        return productServiceAPIClient.getOpinions(productCode,pageRequestDto);
    }

    @Override
    public Page<OpinionDto> getProductOpinionsByScore(
        String productCode,
        Integer score,
        Integer pageNumber,
        Integer pageSize,
        String sortHow,
        String... sortBy
    ) {
        PageRequestDto pageRequestDto = new PageRequestDto(pageNumber, pageSize, sortHow, sortBy);
        return productServiceAPIClient.getOpinionsByScore(productCode,score,pageRequestDto);
    }
}
