package pl.dudi.managementservice.service.apiclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.dudi.managementservice.configuration.feign.FeignClientConfig;
import pl.dudi.managementservice.dto.InvoiceDto;
import pl.dudi.managementservice.dto.InvoiceRequestDto;

@FeignClient(name="customer-service",configuration = FeignClientConfig.class)
public interface AccountServiceApiClient {

    @PostMapping("/invoice")
    InvoiceDto issueInvoice(@RequestBody InvoiceRequestDto invoiceRequestDto);

}
