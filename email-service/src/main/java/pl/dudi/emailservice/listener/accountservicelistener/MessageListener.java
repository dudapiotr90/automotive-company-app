package pl.dudi.emailservice.listener.accountservicelistener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import pl.dudi.emailservice.dto.CustomerOrderMessage;
import pl.dudi.emailservice.dto.EmailMessage;
import pl.dudi.emailservice.dto.InvoiceDto;
import pl.dudi.emailservice.model.emailtemplates.IssuedOrderEmailTemplate;
import pl.dudi.emailservice.service.impl.EmailSenderService;

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
    public String consumeOrderServiceEmailMessage(CustomerOrderMessage message) {
        emailSenderService.sendEmail(message.customer().getEmail(), IssuedOrderEmailTemplate.emailBody, IssuedOrderEmailTemplate.emailSubject);
        return "Email successfully send to your mailbox";
    }


    @RabbitListener(queues = {"${rabbitmq.queue.management.email.name}"})
    public String consumeManagementServiceEmailMessage(InvoiceDto message) {
        // TODO
//        emailSenderService.sendEmailWithAttachment();
        return "Email successfully send to customer's mailbox";
    }

}
