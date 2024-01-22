package pl.dudi.emailservice.dto;

import lombok.Value;

@Value
public class EmailMessage {

    String toEmail;
    String body;
    String subject;
}
