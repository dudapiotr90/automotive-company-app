package pl.dudi.fileservice.model;


import java.time.OffsetDateTime;

public record InvoiceData(
    String key,
    String name,
    String invoiceNumber,
    String link,
    OffsetDateTime expires
) {
}
