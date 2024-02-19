package pl.dudi.managementservice.service;

import pl.dudi.managementservice.dto.Invoice;

public interface InvoiceService {
    Invoice issueInvoice(String orderNumber);
}
