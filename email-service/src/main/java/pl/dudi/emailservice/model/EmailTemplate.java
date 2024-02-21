package pl.dudi.emailservice.model;

public record EmailTemplate(
    String body,
    String subject
) {
}
