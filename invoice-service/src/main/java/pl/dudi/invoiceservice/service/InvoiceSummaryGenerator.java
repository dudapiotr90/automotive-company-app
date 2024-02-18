package pl.dudi.invoiceservice.service;

import com.itextpdf.layout.Document;
import pl.dudi.invoiceservice.dto.InvoiceDto;

public interface InvoiceSummaryGenerator {
    void prepareSummary(Document document, InvoiceDto invoice);
}
