package pl.dudi.clientservice.service.feignservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.dudi.basedomains.dto.CustomerDto;
import pl.dudi.clientservice.configuration.feign.FeignClientConfig;

@FeignClient(name="account-service",configuration = FeignClientConfig.class)
public interface AccountServiceAPIClient {

    @PostMapping("/accounts/customer")
    String registerCustomerAccount(@RequestBody CustomerDto customer);
}
