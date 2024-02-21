package pl.dudi.emailservice.dto;

public record EmailDetails(
    InvoiceDto invoice,
    String email
) {
}
