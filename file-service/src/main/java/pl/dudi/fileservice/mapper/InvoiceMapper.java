package pl.dudi.fileservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.dudi.fileservice.infrastructure.database.document.InvoiceDataDocument;
import pl.dudi.fileservice.model.InvoiceData;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface InvoiceMapper {

    InvoiceDataDocument mapToDocument(InvoiceData invoiceData);

    InvoiceData mapFromDocument(InvoiceDataDocument invoiceDataDocument);
}
