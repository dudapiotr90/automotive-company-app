package pl.dudi.invoiceservice.service;

import com.itextpdf.layout.Document;
import pl.dudi.invoiceservice.model.Invoice;

public interface InvoiceSummaryGenerator {
    void prepareSummary(Document document, Invoice invoice);
}
