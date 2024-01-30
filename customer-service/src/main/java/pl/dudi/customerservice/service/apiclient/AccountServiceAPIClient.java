package pl.dudi.customerservice.service.apiclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.dudi.basedomains.dto.CustomerDto;
import pl.dudi.customerservice.configuration.feign.FeignClientConfig;

@FeignClient(name="account-service",configuration = FeignClientConfig.class)
public interface AccountServiceAPIClient {

    @PostMapping("/accounts/customer")
    CustomerDto registerCustomerAccount(@RequestBody CustomerDto customer);

    @GetMapping("accounts/customer/{code}")
    CustomerDto findCustomerAccount(@PathVariable("code") int customerCode);
}
