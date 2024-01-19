package pl.dudi.accountservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dudi.basedomains.dto.CustomerDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts/customer")
public class CustomerController {

    @PostMapping
    public String registerCustomer(@RequestBody CustomerDto customer) {
        // TODO Added customer to database and send Email
        return "Added";

    }

}
