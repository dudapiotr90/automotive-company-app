package pl.dudi.fileservice.infrastructure.database.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import pl.dudi.fileservice.infrastructure.database.dao.InvoiceDao;
import pl.dudi.fileservice.infrastructure.database.document.InvoiceDataDocument;
import pl.dudi.fileservice.infrastructure.database.repository.mongo.InvoiceMongoRepository;
import pl.dudi.fileservice.mapper.InvoiceMapper;
import pl.dudi.fileservice.model.InvoiceData;

@Slf4j
@Repository
@RequiredArgsConstructor
public class InvoiceRepository implements InvoiceDao {

    private final InvoiceMongoRepository invoiceMongoRepository;
    private final InvoiceMapper invoiceMapper;
    @Override
    public void saveInvoiceData(InvoiceData invoiceData) {
        InvoiceDataDocument invoice= invoiceMapper.mapToDocument(invoiceData);
        invoiceMongoRepository.save(invoice);
    }
}
