package pl.dudi.accountservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.dudi.accountservice.infrastructure.database.entity.CustomerEntity;
import pl.dudi.accountservice.model.Customer;
import pl.dudi.basedomains.dto.CustomerDto;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,uses = AccountMapper.class)
public interface CustomerMapper {

    CustomerDto mapToCustomerDto(Customer customer);
    Customer mapToCustomer(CustomerDto customer);
    CustomerEntity mapToCustomerEntity(Customer customer);
    Customer mapToCustomer(CustomerEntity customer);
}
