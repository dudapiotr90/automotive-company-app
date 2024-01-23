package pl.dudi.accountservice.dto;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class EmailMessage {

    String toEmail;
    String body;
    String subject;
}
