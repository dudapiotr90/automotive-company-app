package pl.dudi.emailservice.dto;

public record InvoiceDto(
    byte[] attachment,
    String invoiceNumber
) {
}
