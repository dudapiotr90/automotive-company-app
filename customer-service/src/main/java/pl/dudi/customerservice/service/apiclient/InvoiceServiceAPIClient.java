package pl.dudi.customerservice.service.apiclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import pl.dudi.basedomains.dto.orders.OrderDto;
import pl.dudi.basedomains.dto.PageRequestDto;
import pl.dudi.customerservice.configuration.feign.FeignClientConfig;
import pl.dudi.customerservice.model.InvoiceDto;

@FeignClient(name="invoice-service",configuration = FeignClientConfig.class)
public interface InvoiceServiceAPIClient {

    @GetMapping("/orders/{code}")
    Page<OrderDto> getOrderHistory(@PathVariable(name = "code") int customerCode, @RequestBody PageRequestDto pageRequestDto);

    @GetMapping("/invoices/{code}")
    Page<InvoiceDto> getInvoiceHistory(@PathVariable(name = "code") int customerCode,@RequestBody PageRequestDto pageRequestDto);
}
