package pl.dudi.orderservice.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dudi.basedomains.dto.OrderDto;
import pl.dudi.basedomains.dto.PageRequestDto;
import pl.dudi.orderservice.dto.InvoiceDto;
import pl.dudi.orderservice.dto.OrderRequestDto;
import pl.dudi.orderservice.dto.OrderResponseMessage;
import pl.dudi.orderservice.service.OrderService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderCustomerController {

    private final OrderService orderService;

    @GetMapping("/{code}")
    public ResponseEntity<Page<OrderDto>> getOrderHistory(
        @PathVariable(name = "code") int customerCode,
        @RequestBody PageRequestDto pageRequestDto
    ){
        Page<OrderDto> orders = orderService.getOrders(customerCode, pageRequestDto);
        return ResponseEntity.ok(orders);
    }

    @PostMapping("/order")
    public ResponseEntity<OrderResponseMessage> issueOrder(
        @RequestHeader("customerCode") int customerCode,
        @RequestBody OrderRequestDto orderRequest
    ) {
        OrderResponseMessage message = orderService.processOrder(customerCode,orderRequest);
        return ResponseEntity.ok(message);
    }

}
