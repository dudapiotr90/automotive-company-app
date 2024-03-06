package pl.dudi.invoiceservice.service;

import com.itextpdf.layout.Document;
import pl.dudi.invoiceservice.dto.request.OrderDetailsDto;

public interface InvoiceItemListGenerator {
    Document prepareProductList(Document document, OrderDetailsDto orderDetailsDto);
}
