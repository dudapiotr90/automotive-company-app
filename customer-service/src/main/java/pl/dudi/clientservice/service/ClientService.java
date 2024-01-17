package pl.dudi.clientservice.service;

import org.springframework.security.oauth2.core.user.OAuth2User;

public interface ClientService {

    void createClientAccount(OAuth2User user);
}
