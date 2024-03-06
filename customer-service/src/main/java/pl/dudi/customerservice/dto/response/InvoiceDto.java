package pl.dudi.customerservice.dto.response;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record InvoiceDto(
    OffsetDateTime issuedAt,
    OffsetDateTime completed,
    String orderNumber,
    String invoiceNumber,
    BigDecimal allItems,
    BigDecimal totalAmount
) {
}
