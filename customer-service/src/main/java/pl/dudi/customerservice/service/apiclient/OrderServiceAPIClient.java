package pl.dudi.customerservice.service.apiclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import pl.dudi.basedomains.dto.PageRequestDto;
import pl.dudi.basedomains.dto.orders.OrderDto;
import pl.dudi.customerservice.dto.request.OrderRequestDto;
import pl.dudi.customerservice.dto.response.OrderDetails;

@FeignClient(name = "order-service")
public interface OrderServiceAPIClient {

    @GetMapping("/orders/{code}")
    Page<OrderDto> getOrderHistory(@PathVariable(name = "code") int customerCode, @RequestBody PageRequestDto pageRequestDto);

    @PostMapping("orders/order")
    OrderDetails submitOrder(@RequestHeader("customerCode") int customerCode, @RequestBody OrderRequestDto request);


    @DeleteMapping("orders/order")
    String cancelOrder(@RequestParam("orderNumber") String orderNumber);

    @PutMapping("/orders/order")
    OrderDetails modifyOrder(
        @RequestHeader("customerCode") int customerCode,
        @RequestParam("orderNumber") String orderNumber,
        @RequestBody OrderRequestDto request
    );
}
