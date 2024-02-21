package pl.dudi.accountservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import pl.dudi.accountservice.infrastructure.database.entity.CustomerEntity;
import pl.dudi.accountservice.model.Customer;
import pl.dudi.basedomains.dto.CustomerDto;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,uses = AccountMapper.class)
public interface CustomerMapper {

    @Mapping(source = "account.login",target = "login")
    @Mapping(source = "account.email",target = "email")
    CustomerDto mapToCustomerDto(Customer customer);
    Customer mapToCustomer(CustomerDto customer);
    CustomerEntity mapToCustomerEntity(Customer customer);

    @Mapping(source = "account",target = "account",qualifiedByName = "mapFromEntity")
    Customer mapToCustomer(CustomerEntity customer);


    @Named("mapLogin")
    default String mapLogin(Customer customer) {
        return customer.getAccount().getLogin();
    }

    @Named("mapEmail")
    default String mapEmail(Customer customer) {
        return customer.getAccount().getEmail();
    }

}
