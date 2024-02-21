package pl.dudi.managementservice.dto;

public record InvoiceDto(
    byte[] attachment,
    String invoiceNumber
) {
}
