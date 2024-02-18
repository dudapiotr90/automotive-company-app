package pl.dudi.invoiceservice.service;

import com.itextpdf.layout.Document;
import pl.dudi.invoiceservice.dto.OrderDetailsDto;

public interface InvoiceCommentsGenerator {
    void prepareComments(Document document, OrderDetailsDto orderDetailsDto);
}
