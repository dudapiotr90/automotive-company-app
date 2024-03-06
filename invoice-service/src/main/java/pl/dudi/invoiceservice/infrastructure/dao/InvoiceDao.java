package pl.dudi.invoiceservice.infrastructure.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.dudi.invoiceservice.infrastructure.entity.InvoiceEntity;
import pl.dudi.invoiceservice.model.Invoice;

public interface InvoiceDao {
    InvoiceEntity findLastInvoice(String email);

    InvoiceEntity saveInvoice(InvoiceEntity invoice);

    Page<Invoice> findInvoices(int customerCode, Pageable pageable);
}
