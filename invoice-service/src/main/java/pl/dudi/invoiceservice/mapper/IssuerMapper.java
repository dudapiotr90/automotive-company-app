package pl.dudi.invoiceservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import pl.dudi.invoiceservice.infrastructure.entity.IssuerEntity;
import pl.dudi.invoiceservice.model.Issuer;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IssuerMapper {

    @Named("mapToIssuerEntity")
    @Mapping(target = "invoices",ignore = true)
    IssuerEntity mapToEntity(Issuer issuer);
    @Named("mapToIssuer")
    @Mapping(target = "invoices",ignore = true)
    Issuer mapFromEntity(IssuerEntity issuer);
}
