package pl.dudi.basedomains.dto;

public record EmailMessage(
    String toEmail,
    String body,
    String subject
) {
}
