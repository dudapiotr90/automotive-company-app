package pl.dudi.accountservice.service;

import pl.dudi.basedomains.dto.CustomerDto;

public interface RegistrationService {
    CustomerDto registerCustomer(CustomerDto customer);
}
