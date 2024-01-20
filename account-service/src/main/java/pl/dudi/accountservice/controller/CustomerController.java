package pl.dudi.accountservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dudi.accountservice.service.RegistrationService;
import pl.dudi.accountservice.service.producer.EmailProducer;
import pl.dudi.basedomains.dto.CustomerDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts/customer")
public class CustomerController {

    private final RegistrationService registrationService;
    private final EmailProducer emailProducer;
    @PostMapping
    public String registerCustomer(@RequestBody CustomerDto customer) {
        CustomerDto customerDto = registrationService.registerCustomer(customer);
//        emailProducer.sendEmail();
        // TODO implement EmailProducer with rabbitmq and docker
        return "Added";

    }

}
