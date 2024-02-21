package pl.dudi.customerservice.service;

import pl.dudi.customerservice.dto.OpinionDto;

public interface ProductService {
    String submitOpinion(String productNumber, OpinionDto opinion);
}
