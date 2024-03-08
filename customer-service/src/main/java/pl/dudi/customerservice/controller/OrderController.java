package pl.dudi.customerservice.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;
import pl.dudi.customerservice.dto.request.OrderRequestDto;
import pl.dudi.customerservice.dto.response.OrderDetails;
import pl.dudi.customerservice.service.OrderService;

@RestController
@RequestMapping("/customer/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDetails> issueOrder(
        @AuthenticationPrincipal OAuth2User user,
        @RequestBody OrderRequestDto request
    ) {
        OrderDetails order = orderService.submitOrder(user, request);
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .body(order);
    }

    @DeleteMapping
    public ResponseEntity<String> cancelOrder(
        @RequestParam String orderNumber
    ) {
        String confirmationMessage = orderService.cancelOrder(orderNumber);
        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_TYPE,MediaType.TEXT_PLAIN_VALUE)
            .body(confirmationMessage);
    }

    @PutMapping
    public ResponseEntity<OrderDetails> modifyOrder(
        @AuthenticationPrincipal OAuth2User user,
        @RequestParam String orderNumber,
        @RequestBody OrderRequestDto request
    ) {
        OrderDetails order = orderService.modifyOrder(user, orderNumber, request);
        return ResponseEntity
            .ok()
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .body(order);
    }

}
