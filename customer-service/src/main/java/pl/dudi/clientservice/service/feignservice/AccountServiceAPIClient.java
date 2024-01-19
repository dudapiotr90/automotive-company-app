package pl.dudi.clientservice.service.feignservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.dudi.basedomains.dto.CustomerDto;

@FeignClient(name="account-service")
public interface AccountServiceAPIClient {

    @PostMapping("/accounts/customer")
    String registerCustomerAccount(@RequestBody CustomerDto customer);
}
