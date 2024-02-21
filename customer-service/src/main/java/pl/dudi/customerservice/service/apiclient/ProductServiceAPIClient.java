package pl.dudi.customerservice.service.apiclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.dudi.customerservice.configuration.feign.FeignClientConfig;
import pl.dudi.customerservice.model.OpinionRequest;

@FeignClient(name = "product-service",configuration = FeignClientConfig.class)
public interface ProductServiceAPIClient {

    @PostMapping("/opinion")
    String submitOpinion(@RequestBody OpinionRequest opinionRequest);
}
