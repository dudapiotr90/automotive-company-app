package pl.dudi.emailservice.listener.accountservicelistener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import pl.dudi.emailservice.dto.CustomerOrderMessage;
import pl.dudi.emailservice.dto.EmailMessage;
import pl.dudi.emailservice.model.emailtemplates.IssuedOrderEmailTemplate;
import pl.dudi.emailservice.service.EmailSenderService;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageListener {

    private final EmailSenderService emailSenderService;

    @RabbitListener(queues = {"${rabbitmq.queue.account.email.name}"})
    public void consumeAccountServiceEmailMessage(EmailMessage message) {
        emailSenderService.sendEmail(message.getToEmail(), message.getBody(), message.getSubject());
    }


    @RabbitListener(queues = {"${rabbitmq.queue.order.email.name}"})
    public void consumeOrderServiceEmailMessage(CustomerOrderMessage message) {
        // TODO create email body
        emailSenderService.sendEmail(message.customer().getEmail(), IssuedOrderEmailTemplate.emailBody, IssuedOrderEmailTemplate.emailSubject);
    }

}
