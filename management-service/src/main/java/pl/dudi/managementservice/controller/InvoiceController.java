package pl.dudi.managementservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.dudi.managementservice.dto.InvoiceDto;
import pl.dudi.managementservice.service.InvoiceService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/management/invoice")
public class InvoiceController {

    private final InvoiceService invoiceService;

    @PostMapping
    public ResponseEntity<InvoiceDto> issueInvoice(
        @RequestParam("orderNumber") String orderNumber
    ) {
        InvoiceDto invoice = invoiceService.issueInvoice(orderNumber);
        return ResponseEntity.ok(invoice);
    }
}
