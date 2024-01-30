package pl.dudi.orderservice.service.apiclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import pl.dudi.basedomains.dto.CustomerDto;
import pl.dudi.orderservice.configuration.feign.FeignClientConfig;
import pl.dudi.orderservice.dto.OrderRequestDto;

@FeignClient(name="management-service",configuration = FeignClientConfig.class)
public interface ManagementServiceAPIClient {


    @PostMapping("/management/order")
    String processOrder(CustomerDto customerDto, OrderRequestDto orderRequest);
}
