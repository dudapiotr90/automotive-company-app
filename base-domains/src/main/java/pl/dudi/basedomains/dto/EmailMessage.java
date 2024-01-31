package pl.dudi.basedomains.dto;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@RequiredArgsConstructor
public record EmailMessage(String toEmail, String body, String subject) {

}
