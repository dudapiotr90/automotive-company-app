package pl.dudi.invoiceservice.service;

import com.itextpdf.layout.Document;
import pl.dudi.invoiceservice.dto.InvoiceDto;

import java.io.IOException;

public interface InvoiceTitleGenerator {
    Document prepareInvoiceTitle(Document document, InvoiceDto invoice) throws IOException;
}
