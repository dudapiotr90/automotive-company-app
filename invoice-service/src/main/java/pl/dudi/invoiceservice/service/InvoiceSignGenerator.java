package pl.dudi.invoiceservice.service;

import com.itextpdf.layout.Document;

public interface InvoiceSignGenerator {
    void addSign(Document document);
}
