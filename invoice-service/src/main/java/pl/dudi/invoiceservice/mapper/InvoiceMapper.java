package pl.dudi.invoiceservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import pl.dudi.invoiceservice.infrastructure.entity.InvoiceEntity;
import pl.dudi.invoiceservice.model.Invoice;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,uses = IssuerMapper.class)
public interface InvoiceMapper {


    @Mapping(target = "issuer",qualifiedByName = "mapToIssuerEntity")
    InvoiceEntity mapToEntity(Invoice invoice);

    @Mapping(target = "issuer",ignore = true)
    Invoice mapFromEntity(InvoiceEntity invoice);
}
