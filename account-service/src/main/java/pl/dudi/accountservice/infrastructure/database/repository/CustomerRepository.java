package pl.dudi.accountservice.infrastructure.database.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.dudi.accountservice.infrastructure.database.entity.CustomerEntity;
import pl.dudi.accountservice.infrastructure.database.repository.dao.CustomerDAO;
import pl.dudi.accountservice.infrastructure.database.repository.jpa.CustomerJpaRepository;
import pl.dudi.accountservice.mapper.CustomerMapper;
import pl.dudi.accountservice.model.Customer;

@Repository
@RequiredArgsConstructor
public class CustomerRepository implements CustomerDAO {

    private final CustomerJpaRepository customerJpaRepository;
    private final CustomerMapper customerMapper;

    @Override
    public Customer addCustomerToDatabase(Customer customer) {
        CustomerEntity customerToAdd = customerMapper.mapToCustomerEntity(customer);
        CustomerEntity customerSaved = customerJpaRepository.save(customerToAdd);
        return customerMapper.mapToCustomer(customerSaved);
    }
}
