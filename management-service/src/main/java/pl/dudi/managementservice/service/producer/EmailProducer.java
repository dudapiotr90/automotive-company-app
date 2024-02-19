package pl.dudi.managementservice.service.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.dudi.basedomains.dto.CustomerDto;
import pl.dudi.managementservice.dto.Invoice;
import pl.dudi.managementservice.model.EmailDetails;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailProducer {

    @Value("${rabbitmq.exchange.management.name}")
    private String exchange;

    @Value("${rabbitmq.binding.management.email.routing.key}")
    private String managementEmailRoutingKey;

    private final RabbitTemplate rabbitTemplate;


    public String sendInvoiceToCustomer(Invoice invoice, CustomerDto customerDetails) {
        EmailDetails emailDetails = new EmailDetails(invoice, customerDetails.getEmail());
        rabbitTemplate.convertSendAndReceive(exchange, managementEmailRoutingKey, emailDetails);
        return null; // TODO
    }
}
