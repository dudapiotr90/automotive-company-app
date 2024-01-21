package pl.dudi.clientservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dudi.basedomains.dto.CustomerDto;
import pl.dudi.clientservice.service.CustomerService;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerHomeController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<CustomerDto> customerDetails(
        @AuthenticationPrincipal OAuth2User user
    ) {

        CustomerDto customerDto = customerService.prepareCustomerDetails(user);


        return ResponseEntity.ok(customerDto);
    }

}
