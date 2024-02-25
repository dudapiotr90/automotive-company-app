package pl.dudi.accountservice.service.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.dudi.basedomains.dto.EmailMessage;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailProducer {

    @Value("${rabbitmq.exchange.account.name}")
    private String exchange;

    @Value("${rabbitmq.binding.account.email.routing.key}")
    private String emailRoutingKey;

    private final RabbitTemplate rabbitTemplate;

    public void sendRegistrationConfirmationEmail(EmailMessage emailMessage) {
        log.info(String.format("Confirmation email sent to RabbitMQ --> %s",emailMessage));
        rabbitTemplate.convertSendAndReceive(exchange, emailRoutingKey, emailMessage); // TODO add message if sending email fails
    }
}
