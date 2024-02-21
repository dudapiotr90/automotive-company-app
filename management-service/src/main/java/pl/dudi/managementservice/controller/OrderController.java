package pl.dudi.managementservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dudi.basedomains.dto.orders.OrderDto;
import pl.dudi.managementservice.dto.ProductionTaskDto;
import pl.dudi.managementservice.service.OrderService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/management")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/order/{number}")
    public ResponseEntity<OrderDto> showOrder(
        @PathVariable(name = "number") String orderNumber
    ) {
        OrderDto order = orderService.showOrder(orderNumber);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/order")
    public ResponseEntity<List<OrderDto>> showOrdersToProcess(
        @RequestHeader("manager-code") int managerCode,     // TODO refactor to extract managerCode form OAuth or JWT
        @RequestParam("status") String status
    ) {
        List<OrderDto> orders = orderService.showOrdersToProcess(managerCode, status);
        return ResponseEntity.ok(orders);
    }

}
