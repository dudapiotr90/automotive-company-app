package pl.dudi.emailservice.service;

import jakarta.mail.MessagingException;
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

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailSenderService {

    @Value("$(spring.name.username)")
    private String fromMail;

    private final JavaMailSender mailSender;
    @Value("$(temp.file.location)")
    private String tempFileCatalog;

    public void sendEmail(
        String toEmail,
        String body,
        String subject
    ) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(fromMail);
        mailMessage.setSubject(subject);
        mailMessage.setText(body);
        mailMessage.setTo(toEmail);
        mailSender.send(mailMessage);
    }

    public void sendEmailWithAttachment(
        String toEmail,
        String body,
        String subject,
        MultipartFile attachment
    ) throws MessagingException, IOException {

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper
            = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom("spring.email.from@gmail.com");
        mimeMessageHelper.setTo(toEmail);
        mimeMessageHelper.setText(body);
        mimeMessageHelper.setSubject(subject);

        File attachmentFile = new File(tempFileCatalog + attachment.getName());
        attachment.transferTo(attachmentFile);

        FileSystemResource fileSystem
            = new FileSystemResource(attachmentFile);

        mimeMessageHelper.addAttachment(attachment.getName(),fileSystem);

        mailSender.send(mimeMessage);
        log.info("Message send to [{}]",toEmail);

        Files.delete(Paths.get(attachmentFile.getAbsolutePath()));
    }
}
