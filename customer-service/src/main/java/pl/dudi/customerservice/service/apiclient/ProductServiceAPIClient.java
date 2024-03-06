package pl.dudi.customerservice.service.apiclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import pl.dudi.basedomains.dto.PageRequestDto;
import pl.dudi.customerservice.configuration.feign.FeignClientConfig;
import pl.dudi.customerservice.dto.request.OpinionDto;
import pl.dudi.customerservice.model.OpinionRequest;

@FeignClient(name = "product-service",configuration = FeignClientConfig.class)
public interface ProductServiceAPIClient {

    @PostMapping("/opinion")
    String submitOpinion(@RequestBody OpinionRequest opinionRequest);

    @GetMapping("/opinion")
    Page<OpinionDto> getOpinions(@RequestParam(name = "productCode") String productCode, @RequestBody PageRequestDto pageRequestDto);
    @GetMapping("/opinion/{score}")
    Page<OpinionDto> getOpinionsByScore(
        @RequestParam(name = "productCode") String productCode,
        @PathVariable(name = "score") int score,
        @RequestBody PageRequestDto pageRequestDto
    );

}

