package pl.dudi.invoiceservice.service.impl;

import com.itextpdf.layout.Document;
import org.springframework.stereotype.Service;
import pl.dudi.invoiceservice.service.InvoiceTitleGenerator;

@Service
public class InvoiceTitleGeneratorImpl implements InvoiceTitleGenerator {
    @Override
    public Document prepareInvoiceTitle(Document document) {
        return document;
    }
}
