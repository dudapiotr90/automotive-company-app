package pl.dudi.invoiceservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dudi.basedomains.dto.PageRequestDto;
import pl.dudi.invoiceservice.dto.response.InvoiceDetails;
import pl.dudi.invoiceservice.service.InvoiceService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;

    @GetMapping("/{code}")
    public ResponseEntity<Page<InvoiceDetails>> fetchInvoices(
        @PathVariable(name = "code") int customerCode,
        @RequestBody PageRequestDto pageRequestDto
    ) {
        Page<InvoiceDetails> invoices = invoiceService.findInvoices(customerCode, pageRequestDto);
        return ResponseEntity.ok(invoices);
    }
}
