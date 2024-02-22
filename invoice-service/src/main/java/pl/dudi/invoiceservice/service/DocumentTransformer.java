package pl.dudi.invoiceservice.service;

import pl.dudi.invoiceservice.dto.InvoiceDto;
import pl.dudi.invoiceservice.model.Invoice;
import pl.dudi.invoiceservice.model.PdfFile;

public interface DocumentTransformer {
    InvoiceDto prepareInvoiceDto(PdfFile pdf, Invoice invoice);
}
