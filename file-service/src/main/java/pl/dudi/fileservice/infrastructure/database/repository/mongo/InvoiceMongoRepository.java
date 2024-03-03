package pl.dudi.fileservice.infrastructure.database.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.dudi.fileservice.infrastructure.database.document.InvoiceDataDocument;

import java.util.Optional;

@Repository
public interface InvoiceMongoRepository extends MongoRepository<InvoiceDataDocument,String> {
    Optional<InvoiceDataDocument> findByName(String invoiceNumber);

    Optional<InvoiceDataDocument> findByInvoiceNumber(String invoiceNumber);

    void deleteByInvoiceNumber(String invoiceNumber);
}
