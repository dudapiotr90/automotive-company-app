package pl.dudi.managementservice.service;

import pl.dudi.managementservice.dto.InvoiceDto;

public interface InvoiceService {
    InvoiceDto issueInvoice(String orderNumber);
}
