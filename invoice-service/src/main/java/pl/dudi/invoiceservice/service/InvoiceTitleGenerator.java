package pl.dudi.invoiceservice.service;

import com.itextpdf.layout.Document;
import pl.dudi.invoiceservice.model.Invoice;

import java.io.IOException;

public interface InvoiceTitleGenerator {
    Document prepareInvoiceTitle(Document document, Invoice invoice) throws IOException;
}
