package pl.dudi.invoiceservice.service;

import com.itextpdf.layout.Document;
import pl.dudi.invoiceservice.model.Invoice;
import pl.dudi.invoiceservice.dto.InvoiceRequestDto;
import pl.dudi.invoiceservice.model.PdfFile;

public interface InvoiceGenerator {
    PdfFile generateInvoice(InvoiceRequestDto request, Invoice invoice);
}
