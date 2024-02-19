package pl.dudi.invoiceservice.service;

import pl.dudi.invoiceservice.dto.InvoiceDto;
import pl.dudi.invoiceservice.model.Invoice;
import pl.dudi.invoiceservice.dto.InvoiceRequestDto;

public interface InvoiceService {
    InvoiceDto processInvoice(InvoiceRequestDto request);
}
