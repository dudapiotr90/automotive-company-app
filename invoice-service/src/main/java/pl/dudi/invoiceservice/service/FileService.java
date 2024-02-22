package pl.dudi.invoiceservice.service;

import pl.dudi.invoiceservice.dto.InvoiceDto;

public interface FileService {
    void sendFileToExternalHosting(InvoiceDto invoiceDto);
}
