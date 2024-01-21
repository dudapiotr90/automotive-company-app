package pl.dudi.clientservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import pl.dudi.basedomains.dto.CustomerDto;
import pl.dudi.clientservice.service.CustomerService;
import pl.dudi.clientservice.service.feignservice.AccountServiceAPIClient;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final AccountServiceAPIClient accountServiceAPIClient;

    @Override
    public CustomerDto prepareCustomerDetails(OAuth2User user) {
        CustomerDto customer = extractUserData(user);
        CustomerDto existingCustomer = accountServiceAPIClient.findCustomerAccount(customer.getCustomerCode());
        if (Objects.isNull(existingCustomer)) {
            CustomerDto registeredCustomer = accountServiceAPIClient.registerCustomerAccount(customer);
            log.info(String.format("Account %s created" , customer.getCustomerCode()));
            return registeredCustomer;
        }
        return existingCustomer;
    }

    private CustomerDto extractUserData(OAuth2User user) {
        String customerFullName = Objects.requireNonNull(user.getName());
        int customerId = Objects.requireNonNull(user.getAttribute("id"));
        String customerLogin = Objects.requireNonNull(user.getAttribute("login"));
        String customerEmail = Objects.requireNonNull(user.getAttribute("email"));
        CustomerDto customerDto = new CustomerDto(customerFullName, customerId, customerLogin, customerEmail);
        System.out.println(customerDto);
        return customerDto;
    }

}
