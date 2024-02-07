package pl.dudi.invoiceservice.service;

import pl.dudi.invoiceservice.dto.InvoiceDto;
import pl.dudi.invoiceservice.dto.InvoiceRequestDto;

import java.io.FileNotFoundException;

public interface InvoiceService {
    InvoiceDto generateInvoice(InvoiceRequestDto request);
}
