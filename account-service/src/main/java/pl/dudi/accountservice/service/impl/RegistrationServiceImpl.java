package pl.dudi.accountservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.dudi.accountservice.infrastructure.database.dao.CustomerDAO;
import pl.dudi.accountservice.mapper.CustomerMapper;
import pl.dudi.accountservice.model.Account;
import pl.dudi.accountservice.model.Customer;
import pl.dudi.accountservice.service.RegistrationService;
import pl.dudi.accountservice.utility.Authorities;
import pl.dudi.accountservice.utility.UUIDGenerator;
import pl.dudi.basedomains.dto.CustomerDto;

import java.time.OffsetDateTime;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final CustomerDAO customerDAO;
    private final CustomerMapper customerMapper;
    private final PasswordEncoder encoder;
    private final UUIDGenerator generator;
    @Override
    public CustomerDto registerCustomer(CustomerDto customerDto) {
        Customer customer = buildCustomer(customerDto);
        Customer savedCustomer = customerDAO.addCustomerToDatabase(customer);
        return customerMapper.mapToCustomerDto(savedCustomer);
    }

    @Override
    public CustomerDto findCustomer(int customerCode) {
        Customer customer = customerDAO.findCustomer(customerCode);
        return customerMapper.mapToCustomerDto(customer);
    }

    private Customer buildCustomer(CustomerDto customerDto) {
        return Customer.builder()
            .fullName(customerDto.getFullName())
            .customerCode(customerDto.getCustomerCode())
            .account(Account.builder()
                .email(customerDto.getEmail())
                .login(customerDto.getLogin())
                .password(encoder.encode(generator.generateUuid()))
                .role(Authorities.CUSTOMER)
                .creationDate(OffsetDateTime.now())
                .build()                            )
            .build();
    }
}
