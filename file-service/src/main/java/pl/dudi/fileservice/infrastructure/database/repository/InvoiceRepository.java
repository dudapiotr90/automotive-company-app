package pl.dudi.fileservice.infrastructure.database.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import pl.dudi.fileservice.exception.DocumentNotFoundException;
import pl.dudi.fileservice.infrastructure.database.dao.InvoiceDao;
import pl.dudi.fileservice.infrastructure.database.document.InvoiceDataDocument;
import pl.dudi.fileservice.infrastructure.database.repository.mongo.InvoiceMongoRepository;
import pl.dudi.fileservice.mapper.InvoiceMapper;
import pl.dudi.fileservice.model.InvoiceData;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

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

    @Override
    public InvoiceData fetchInvoice(String invoiceNumber) {
        InvoiceDataDocument invoice = invoiceMongoRepository.findByInvoiceNumber(invoiceNumber)
            .orElseThrow(
                () -> new DocumentNotFoundException("There is no invoice with given invoiceNumber: [%s]".formatted(invoiceNumber))
            );
        return invoiceMapper.mapFromDocument(invoice);
    }

    @Override
    public void deleteInvoice(InvoiceData invoiceData) {
        invoiceMongoRepository.deleteByInvoiceNumber(invoiceData.invoiceNumber());
    }

    @Override
    public InvoiceData updateInvoice(String invoiceNumber) {
        InvoiceDataDocument invoice = invoiceMongoRepository.findByInvoiceNumber(invoiceNumber)
            .orElseThrow(
                () -> new DocumentNotFoundException("There is no invoice with given invoiceNumber: [%s]".formatted(invoiceNumber))
            );
        invoice.setExpires(OffsetDateTime.now().plusDays(2));
        InvoiceDataDocument saved = invoiceMongoRepository.save(invoice);
        return invoiceMapper.mapFromDocument(saved);
    }
}
