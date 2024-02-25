package pl.dudi.accountservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dudi.accountservice.model.Customer;
import pl.dudi.accountservice.service.EmailService;
import pl.dudi.accountservice.service.producer.EmailProducer;
import pl.dudi.basedomains.dto.EmailMessage;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final EmailProducer emailProducer;


    @Override
    public void sendConfirmationEmail(Customer customer) {
        EmailMessage emailMessage = new EmailMessage(
            customer.getAccount().getEmail(),
            CONFIRMATION_EMAIL_BODY.formatted(customer.getFullName()),
            SUBJECT
        );
        emailProducer.sendRegistrationConfirmationEmail(emailMessage);
    }
}
