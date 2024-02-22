package pl.dudi.invoiceservice.infrastructure.dao;

import pl.dudi.invoiceservice.infrastructure.entity.InvoiceEntity;
import pl.dudi.invoiceservice.model.Invoice;

public interface InvoiceDao {
    InvoiceEntity findLastInvoice(String email);

    InvoiceEntity saveInvoice(InvoiceEntity invoice);
}
