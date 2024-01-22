package pl.dudi.emailservice.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import pl.dudi.emailservice.dto.EmailMessage;
import pl.dudi.emailservice.service.EmailSenderService;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageListener {

    private final EmailSenderService emailSenderService;

    @RabbitListener(queues = {"${rabbitmq.queue.account.email.name}"})
    public void consumeAccountServiceEmailMessage(EmailMessage emailMessage) {
        emailSenderService.sendEmail(emailMessage.getToEmail(), emailMessage.getBody(), emailMessage.getSubject());
    }

}
