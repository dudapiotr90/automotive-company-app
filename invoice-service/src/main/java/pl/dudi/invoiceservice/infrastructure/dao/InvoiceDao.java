package pl.dudi.invoiceservice.infrastructure.dao;

import pl.dudi.invoiceservice.infrastructure.entity.InvoiceEntity;

public interface InvoiceDao {
    InvoiceEntity findLastInvoice(String email);
}
