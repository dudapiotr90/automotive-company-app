package pl.dudi.fileservice.infrastructure.database.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import pl.dudi.fileservice.infrastructure.database.dao.InvoiceDao;
import pl.dudi.fileservice.model.InvoiceData;

@Slf4j
@Repository
@RequiredArgsConstructor
public class InvoiceRepository implements InvoiceDao {

    @Override
    public InvoiceData saveInvoiceData(InvoiceData invoiceData) {
        return null; // TODO learn Spring MongoDB
    }
}
