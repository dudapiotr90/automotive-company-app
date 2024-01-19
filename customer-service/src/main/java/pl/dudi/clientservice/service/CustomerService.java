package pl.dudi.clientservice.service;

import org.springframework.security.oauth2.core.user.OAuth2User;

public interface CustomerService {

    void createCustomerAccount(OAuth2User user);
}
