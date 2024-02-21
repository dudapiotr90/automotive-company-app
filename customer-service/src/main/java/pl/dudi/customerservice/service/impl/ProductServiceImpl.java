package pl.dudi.customerservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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
}
