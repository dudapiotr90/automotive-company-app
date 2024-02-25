package pl.dudi.fileservice.service;

import pl.dudi.fileservice.dto.InvoiceDto;

public interface FileService {
    void saveInvoice(InvoiceDto invoiceDto);
}
