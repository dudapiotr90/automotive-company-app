package pl.dudi.emailservice.listener.accountservicelistener;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.dudi.emailservice.dto.CustomerOrderMessage;
import pl.dudi.emailservice.dto.EmailDetails;
import pl.dudi.emailservice.dto.EmailMessage;
import pl.dudi.emailservice.model.EmailTemplate;
import pl.dudi.emailservice.model.emailtemplates.IssuedOrderEmailTemplate;
import pl.dudi.emailservice.service.EmailTemplateService;
import pl.dudi.emailservice.service.MultipartFileService;
import pl.dudi.emailservice.service.impl.EmailSenderService;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageListener {

    private final EmailSenderService emailSenderService;
    private final MultipartFileService multipartFileService;
    private final EmailTemplateService emailTemplateService;

//    @RabbitListener(queues = {"${rabbitmq.queue.account.email.name}"})
//    public void consumeAccountServiceEmailMessage(EmailMessage message) {
//        emailSenderService.sendEmail(message.toEmail(), message.body(), message.subject());
//    }
//
//
//    @RabbitListener(queues = {"${rabbitmq.queue.order.email.name}"})
//    public String consumeOrderServiceEmailMessage(CustomerOrderMessage message) {
//        emailSenderService.sendEmail(message.customer().getEmail(), IssuedOrderEmailTemplate.emailBody, IssuedOrderEmailTemplate.emailSubject);
//        return "Email successfully send to your mailbox";
//    }


    @RabbitListener(queues = {"${rabbitmq.queue.management.email.name}"})
    public String consumeManagementServiceEmailMessage(EmailDetails message) throws MessagingException {
        MultipartFile attachment = multipartFileService.createMultipartFile(message.invoice());
        EmailTemplate emailTemplate = emailTemplateService.getInvoiceTemplate();
        emailSenderService.sendEmailWithAttachment(message.email(),emailTemplate.body(),emailTemplate.subject(),attachment);
        return "Email successfully send to customer's mailbox";
    }

}
