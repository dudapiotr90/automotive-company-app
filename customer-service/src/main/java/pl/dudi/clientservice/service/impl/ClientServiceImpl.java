package pl.dudi.clientservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import pl.dudi.clientservice.dto.CustomerDto;
import pl.dudi.clientservice.service.ClientService;
import pl.dudi.clientservice.service.feignservice.AccountServiceAPIClient;

import java.util.Objects;
@Slf4j
@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final AccountServiceAPIClient accountServiceAPIClient;
    @Override
    public void createClientAccount(OAuth2User user) {
        CustomerDto customer = extractUserData(user);
        String response = accountServiceAPIClient.registerCustomerAccount(customer);
        log.info(String.format("Account %s"+response,customer.getAccount_code()));
    }

    private CustomerDto extractUserData(OAuth2User user) {
        String[] customerLogin = Objects.requireNonNull(user.getAttribute("name")).toString().split(" ");
        if (customerLogin.length <= 2) {
            customerLogin[1] = "";
        }
        String customerEmail = Objects.requireNonNull(user.getAttribute("email")).toString();
        long customerId = Objects.requireNonNull(user.getAttribute("id"));
        return new CustomerDto(customerLogin[0],customerLogin[1], customerEmail,customerId);
    }
}
