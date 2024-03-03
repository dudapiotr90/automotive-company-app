package pl.dudi.fileservice.infrastructure.database.dao;


import pl.dudi.fileservice.model.InvoiceData;

public interface InvoiceDao {
    void saveInvoiceData(InvoiceData invoiceData);

    InvoiceData fetchInvoice(String invoiceNumber);

    void deleteInvoice(InvoiceData invoiceData);

    InvoiceData updateInvoice(String invoiceNumber);
}
