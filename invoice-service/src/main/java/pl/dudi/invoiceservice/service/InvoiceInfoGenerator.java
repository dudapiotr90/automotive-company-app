package pl.dudi.invoiceservice.service;

import com.itextpdf.layout.Document;
import pl.dudi.invoiceservice.dto.InvoiceRequestDto;

public interface InvoiceInfoGenerator {
    Document prepareInfoSection(InvoiceRequestDto request, Document document);
}
