package pl.dudi.emailservice.service.impl;

import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.dudi.emailservice.service.EmailService;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailSenderService implements EmailService {

    @Value("$(spring.name.username)")
    private String fromMail;

    private final JavaMailSender mailSender;
    @Value("$(temp.file.location)")
    private String tempFileCatalog;

    @Override
    public void sendEmail(
        String toEmail,
        String body,
        String subject
    ) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(fromMail);  // TODO check why spring.name.username shows in email and not actual email address

        mailMessage.setSubject(subject);
        mailMessage.setText(body);
        mailMessage.setTo(toEmail);
        mailSender.send(mailMessage);
    }

    @Override
    public void sendEmailWithAttachment(
        String toEmail,
        String body,
        String subject,
        MultipartFile attachment
    )  {
        try {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper
            = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom(fromMail);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(body);
        mimeMessageHelper.setTo(toEmail);

        File attachmentFile = new File(tempFileCatalog + attachment.getName());

            attachment.transferTo(attachmentFile);
            FileSystemResource fileSystem
                = new FileSystemResource(attachmentFile);

            mimeMessageHelper.addAttachment(attachment.getName(),fileSystem);

            mailSender.send(mimeMessage);
            log.info("Message send to [{}]",toEmail);

            Files.deleteIfExists(Paths.get(attachmentFile.getAbsolutePath()));
        } catch (Exception e) {
            log.error("Error occurred while sending message with attachment file");
            throw new RuntimeException(); // TODO make custom exception
        }
    }
}
