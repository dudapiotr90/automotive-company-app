package pl.dudi.orderservice.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dudi.basedomains.dto.PageRequestDto;
import pl.dudi.basedomains.dto.orders.OrderDto;
import pl.dudi.orderservice.dto.OrderRequestDto;
import pl.dudi.orderservice.dto.OrderResponseMessage;
import pl.dudi.orderservice.model.Status;
import pl.dudi.orderservice.service.OrderService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/{customerCode}")
    public ResponseEntity<Page<OrderDto>> getOrderHistory(
        @PathVariable(name = "customerCode") int customerCode,
        @RequestParam(name="status",required = false) Status status,
        @RequestBody PageRequestDto pageRequestDto
    ){
        Page<OrderDto> orders = orderService.getOrders(customerCode, pageRequestDto,status);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/order/{number}")
    public ResponseEntity<OrderDto> getOrderByOrderNumber(
        @PathVariable(name = "code") String orderNumber
    ){
        OrderDto order = orderService.getOrder(orderNumber);
        return ResponseEntity.ok(order);
    }


    @PostMapping("/order")
    public ResponseEntity<OrderDto> issueOrder(
        @RequestHeader("customerCode") int customerCode,
        @RequestBody OrderRequestDto orderRequest
    ) {
        OrderDto order = orderService.processOrder(customerCode,orderRequest);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/process")
    public ResponseEntity<List<OrderDto>> getOrdersToProcess(
        @RequestHeader("managerCode") int managerCode,
        @RequestParam("status") String status
    ){
        List<OrderDto> orders = orderService.getOrdersToProcess(status);
        return ResponseEntity.ok(orders);
    }

    @DeleteMapping("/order")
    public ResponseEntity<String> cancelOrder(
        @RequestParam("orderNumber") String orderNumber
    ) {
        String confirmationMessage = orderService.cancelOrder(orderNumber);
        return ResponseEntity.ok(confirmationMessage);
    }
}
