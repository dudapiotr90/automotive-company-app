package pl.dudi.customerservice.service.apiclient;

import org.springframework.cloud.openfeign.FeignClient;
import pl.dudi.customerservice.configuration.feign.FeignClientConfig;

@FeignClient(name = "product-service",configuration = FeignClientConfig.class)
public interface ProductServiceAPIClient {
}
