package pl.dudi.invoiceservice.service;

import pl.dudi.invoiceservice.dto.response.InvoiceFile;
import pl.dudi.invoiceservice.model.Invoice;
import pl.dudi.invoiceservice.model.PdfFile;

public interface DocumentTransformer {
    InvoiceFile prepareInvoiceDto(PdfFile pdf, Invoice invoice);
}
