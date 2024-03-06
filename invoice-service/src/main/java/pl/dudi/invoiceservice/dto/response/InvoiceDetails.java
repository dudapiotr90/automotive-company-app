package pl.dudi.invoiceservice.dto.response;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record InvoiceDetails(
    OffsetDateTime issuedAt,
    OffsetDateTime completed,
    String orderNumber,
    String invoiceNumber,
    BigDecimal allItems,
    BigDecimal totalAmount
) {
}
