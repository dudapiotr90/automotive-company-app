package pl.dudi.emailservice.service;

import jakarta.mail.MessagingException;
import org.springframework.web.multipart.MultipartFile;

public interface EmailService {

    String CONFIRMATION_MESSAGE = "Email successfully send";
    String sendEmail(String toEmail, String body, String subject);
    String sendEmailWithAttachment(String toEmail,String body,String subject,MultipartFile attachment) throws MessagingException;

}
