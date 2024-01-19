package pl.dudi.clientservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dudi.clientservice.configuration.security.CustomOAuth2User;
import pl.dudi.clientservice.service.CustomerService;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerHomeController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<String> customerDetails(
        @AuthenticationPrincipal OAuth2User user
    ) {
        System.out.println(user.getAttributes());
        System.out.println(user.getAuthorities());
        customerService.createCustomerAccount(user);
        return ResponseEntity.ok("You've been added to our database");
    }

}
