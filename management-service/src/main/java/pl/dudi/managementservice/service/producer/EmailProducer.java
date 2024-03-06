package pl.dudi.managementservice.service.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.dudi.basedomains.dto.CustomerDto;
import pl.dudi.managementservice.dto.InvoiceDto;
import pl.dudi.managementservice.model.EmailDetails;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailProducer {

    private final RabbitTemplate rabbitTemplate;
    @Value("${rabbitmq.exchange.management.name}")
    private String exchange;
    @Value("${rabbitmq.binding.management.email.routing.key}")
    private String managementEmailRoutingKey;

    public void sendInvoiceToCustomer(InvoiceDto invoice, CustomerDto customerDetails) {
        EmailDetails emailDetails = new EmailDetails(invoice, customerDetails.email());
        Object response = rabbitTemplate.convertSendAndReceive(exchange, managementEmailRoutingKey, emailDetails);
    }
}
