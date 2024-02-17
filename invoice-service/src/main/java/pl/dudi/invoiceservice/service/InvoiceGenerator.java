package pl.dudi.invoiceservice.service;

import com.itextpdf.layout.Document;
import pl.dudi.invoiceservice.dto.InvoiceDto;
import pl.dudi.invoiceservice.dto.InvoiceRequestDto;

public interface InvoiceGenerator {
    Document generateInvoice(InvoiceRequestDto request, InvoiceDto invoice);
}
