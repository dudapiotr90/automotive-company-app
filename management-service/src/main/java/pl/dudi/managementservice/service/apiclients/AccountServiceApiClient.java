package pl.dudi.managementservice.service.apiclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.dudi.basedomains.dto.CustomerDto;
import pl.dudi.managementservice.configuration.feign.FeignClientConfig;
import pl.dudi.managementservice.dto.Invoice;
import pl.dudi.managementservice.dto.InvoiceRequestDto;

@FeignClient(name="customer-service",configuration = FeignClientConfig.class)
public interface AccountServiceApiClient {

    @PostMapping("/invoice")
    Invoice issueInvoice(@RequestBody InvoiceRequestDto invoiceRequestDto);


    @GetMapping("accounts/customer/{code}")
    CustomerDto getCustomerDetails(@PathVariable("code") int customerCode);
}
