package pl.dudi.accountservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<CustomerDto> registerCustomer(@RequestBody CustomerDto customer) {
        CustomerDto customerDto = registrationService.registerCustomer(customer);
//        emailProducer.sendEmail();
        // TODO implement EmailProducer with rabbitmq and docker
        return new ResponseEntity<>(customerDto, HttpStatus.CREATED);

    }

    @GetMapping("{code}")
    public  ResponseEntity<CustomerDto> getCustomerDetails(
        @PathVariable("code") int customerCode
    ) {
        CustomerDto customerDto = registrationService.findCustomer(customerCode);
        return ResponseEntity.ok(customerDto);
    }


}
