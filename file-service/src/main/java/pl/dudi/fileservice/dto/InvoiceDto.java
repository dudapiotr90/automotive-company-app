package pl.dudi.fileservice.dto;

public record InvoiceDto(
    byte[] file,
    String invoiceNumber
) {
}
