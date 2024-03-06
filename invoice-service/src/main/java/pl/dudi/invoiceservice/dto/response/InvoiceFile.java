package pl.dudi.invoiceservice.dto.response;

public record InvoiceFile(
    byte[] file,
    String invoiceNumber
) {
}
