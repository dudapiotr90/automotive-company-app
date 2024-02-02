package pl.dudi.managementservice.service.apiclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import pl.dudi.basedomains.dto.orders.OrderDto;
import pl.dudi.managementservice.configuration.feign.FeignClientConfig;

import java.util.List;

@FeignClient(name="management-service",configuration = FeignClientConfig.class)
public interface OrderServiceApiClient {


    @GetMapping("orders/order/{number}")
    OrderDto showOrder(@PathVariable("number") String orderNumber);

    @GetMapping("orders/process")
    List<OrderDto> showOrdersToProcess(@RequestHeader("managerCode") int managerCode,@RequestParam("status") String status);

}
