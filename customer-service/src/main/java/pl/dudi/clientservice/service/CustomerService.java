package pl.dudi.clientservice.service;

import org.springframework.security.oauth2.core.user.OAuth2User;
import pl.dudi.basedomains.dto.CustomerDto;

public interface CustomerService {

    CustomerDto prepareCustomerDetails(OAuth2User user);

    CustomerDto extractUserData(OAuth2User user);
}
