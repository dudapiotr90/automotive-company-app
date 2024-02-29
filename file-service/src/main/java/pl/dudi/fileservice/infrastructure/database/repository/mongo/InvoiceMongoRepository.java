package pl.dudi.fileservice.infrastructure.database.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.dudi.fileservice.infrastructure.database.document.InvoiceDataDocument;

@Repository
public interface InvoiceMongoRepository extends MongoRepository<InvoiceDataDocument,String> {
}
