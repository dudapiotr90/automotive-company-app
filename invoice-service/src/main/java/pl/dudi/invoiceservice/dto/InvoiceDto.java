package pl.dudi.invoiceservice.dto;

public record InvoiceDto(
    byte[] file,
    String invoiceNumber
) {
}
