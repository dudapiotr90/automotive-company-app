package pl.dudi.basedomains.dto;

import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.Objects;
@Value
@RequiredArgsConstructor
public class EmailMessage {

    String toEmail;
    String body;
    String subject;


}
