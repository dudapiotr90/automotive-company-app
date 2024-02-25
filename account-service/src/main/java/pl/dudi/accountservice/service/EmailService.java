package pl.dudi.accountservice.service;

import pl.dudi.accountservice.model.Customer;

public interface EmailService {

    String SUBJECT = "Confirmation email";

    String CONFIRMATION_EMAIL_BODY = """
        <html>
        <body>
        <p>Welcome %s,</p>
                
        <p>Thank you for registering! Check out our features</p>
                
        <p>Best regards<p>
        <br>
        <p> Email automatically generated please do not reply </p>
        </body>
        </html>
        """;
    void sendConfirmationEmail(Customer savedCustomer);
}
