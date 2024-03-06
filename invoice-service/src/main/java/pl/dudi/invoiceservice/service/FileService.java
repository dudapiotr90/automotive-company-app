package pl.dudi.invoiceservice.service;

import pl.dudi.invoiceservice.dto.response.InvoiceFile;

public interface FileService {
    void sendFileToExternalHosting(InvoiceFile invoiceFile);
}
