package pl.dudi.invoiceservice.service;

import pl.dudi.invoiceservice.dto.InvoiceRequestDto;
import pl.dudi.invoiceservice.model.Invoice;

public interface InvoiceService {
    Invoice issueInvoice(InvoiceRequestDto request);
}
