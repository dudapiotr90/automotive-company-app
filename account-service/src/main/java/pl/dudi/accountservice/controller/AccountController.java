package pl.dudi.accountservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dudi.accountservice.service.RegistrationService;
import pl.dudi.basedomains.dto.CustomerDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountController {

    private final RegistrationService registrationService;

    @PostMapping("/customer")
    public ResponseEntity<CustomerDto> registerCustomer(@RequestBody CustomerDto customer) {
        CustomerDto customerDto = registrationService.registerCustomer(customer);
        return new ResponseEntity<>(customerDto, HttpStatus.CREATED);
    }

    @GetMapping("/customer/{code}")
    public  ResponseEntity<CustomerDto> getCustomerDetails(
        @PathVariable("code") int customerCode
    ) {
        CustomerDto customerDto = registrationService.findCustomer(customerCode);
        return ResponseEntity.ok(customerDto);
    }


}
