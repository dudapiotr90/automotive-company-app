package pl.dudi.invoiceservice.service;

import com.itextpdf.layout.Document;

public interface InvoiceTitleGenerator {
    Document prepareInvoiceTitle(Document document);
}
