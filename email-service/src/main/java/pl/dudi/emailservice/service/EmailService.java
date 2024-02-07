package pl.dudi.emailservice.service;

import jakarta.mail.MessagingException;
import org.springframework.web.multipart.MultipartFile;

public interface EmailService {

    void sendEmail(String toEmail, String body, String subject);
    void sendEmailWithAttachment(String toEmail,String body,String subject,MultipartFile attachment) throws MessagingException;

}
