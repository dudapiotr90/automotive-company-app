package pl.dudi.customerservice.service.feignservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import pl.dudi.basedomains.dto.OrderDto;
import pl.dudi.basedomains.dto.PageRequestDto;

@FeignClient(name = "order-service")
public interface OrderServiceAPIClient {

    @GetMapping("/orders/{code}")
    Page<OrderDto> getOrderHistory(@PathVariable(name = "code") int customerCode, @RequestBody PageRequestDto pageRequestDto);

}
