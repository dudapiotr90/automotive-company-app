package pl.dudi.invoiceservice.service;

import pl.dudi.invoiceservice.model.Invoice;
import pl.dudi.invoiceservice.dto.InvoiceRequestDto;

public interface InvoiceDetailsService {
    Invoice prepareInvoiceDetails(InvoiceRequestDto request);
}
