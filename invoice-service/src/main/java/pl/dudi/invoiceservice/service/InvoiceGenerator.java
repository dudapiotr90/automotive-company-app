package pl.dudi.invoiceservice.service;

import pl.dudi.invoiceservice.dto.request.InvoiceRequestDto;
import pl.dudi.invoiceservice.model.Invoice;
import pl.dudi.invoiceservice.model.PdfFile;

public interface InvoiceGenerator {
    PdfFile generateInvoice(InvoiceRequestDto request, Invoice invoice);
}
