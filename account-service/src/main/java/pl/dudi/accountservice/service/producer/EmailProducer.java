package pl.dudi.accountservice.service.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.dudi.accountservice.dto.EmailMessage;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailProducer {

    @Value("${rabbitmq.exchange.account.name}")
    private String exchange;

    @Value("${rabbitmq.binding.email.routing.key}")
    private String emailRoutingKey;

    private final RabbitTemplate rabbitTemplate;

    public void sendRegistrationConfirmationEmail(EmailMessage emailMessage) {
        log.info(String.format("Confirmation email sent to RabbitMQ --> %s",emailMessage));


//        Message message = rabbitTemplate.getMessageConverter().toMessage(emailMessage, new MessageProperties());
//        message.getMessageProperties().setHeaders(headers);

        rabbitTemplate.convertAndSend(exchange,emailRoutingKey,emailMessage);
//        rabbitTemplate.send(exchange,emailRoutingKey,emailMessage);


        //
    }
}
