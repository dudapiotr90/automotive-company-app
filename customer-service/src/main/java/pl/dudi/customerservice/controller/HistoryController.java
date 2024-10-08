package pl.dudi.customerservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.dudi.basedomains.dto.orders.OrderDto;
import pl.dudi.customerservice.dto.response.InvoiceDto;
import pl.dudi.customerservice.service.HistoryService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer/history")
public class HistoryController {


    private final HistoryService historyService;


    // Maybe change outh2user after gateway filter
    @GetMapping("/order")
    public ResponseEntity<Page<OrderDto>> showOrderHistory(
        @AuthenticationPrincipal OAuth2User user,
        @RequestParam(required = false, name = "pageNumber") Integer pageNumber,
        @RequestParam(required = false, name = "pageSize") Integer pageSize,
        @RequestParam(required = false, name = "sortHow") String sortHow,
        @RequestParam(required = false, name = "sortBy") String... sortBy
    ) {
        Page<OrderDto> orderHistory = historyService.showOrderHistory(user, pageNumber, pageSize, sortHow, sortBy);
        return ResponseEntity.ok(orderHistory);
    }

    @GetMapping("/invoice")
    public ResponseEntity<Page<InvoiceDto>> showInvoiceHistory(
        @AuthenticationPrincipal OAuth2User user,
        @RequestParam(required = false, name = "pageNumber") Integer pageNumber,
        @RequestParam(required = false, name = "pageSize") Integer pageSize,
        @RequestParam(required = false, name = "sortHow") String sortHow,
        @RequestParam(required = false, name = "sortBy") String... sortBy
    ) {
        Page<InvoiceDto> invoiceHistory = historyService.showInvoiceHistory(user, pageNumber, pageSize, sortHow, sortBy);
        return ResponseEntity.ok(invoiceHistory);
    }


}
