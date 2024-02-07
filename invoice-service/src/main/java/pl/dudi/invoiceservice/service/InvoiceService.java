package pl.dudi.invoiceservice.service;

import pl.dudi.invoiceservice.dto.InvoiceDto;
import pl.dudi.invoiceservice.dto.InvoiceRequestDto;

public interface InvoiceService {
    InvoiceDto generateInvoice(InvoiceRequestDto request);
}
