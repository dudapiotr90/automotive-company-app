package pl.dudi.emailservice.dto;

public record EmailMessage(
    String toEmail,
    String body,
    String subject
) {
}
