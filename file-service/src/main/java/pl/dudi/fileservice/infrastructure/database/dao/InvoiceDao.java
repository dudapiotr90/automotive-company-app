package pl.dudi.fileservice.infrastructure.database.dao;


import pl.dudi.fileservice.infrastructure.database.document.InvoiceDataDocument;
import pl.dudi.fileservice.model.InvoiceData;

public interface InvoiceDao {
    void saveInvoiceData(InvoiceData invoiceData);
}
