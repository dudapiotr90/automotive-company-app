package pl.dudi.fileservice.infrastructure.database.dao;


import pl.dudi.fileservice.model.InvoiceData;

public interface InvoiceDao {
    InvoiceData saveInvoiceData(InvoiceData invoiceData);
}
