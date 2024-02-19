package pl.dudi.invoiceservice.model;

import pl.dudi.invoiceservice.model.Customer;
import pl.dudi.invoiceservice.model.Issuer;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record Invoice(
    Issuer issuer,
    Customer customer,
    OffsetDateTime issuedAt,
    OffsetDateTime completed,
    String orderNumber,
    String invoiceNumber,
    BigDecimal allItems,
    BigDecimal totalAmount
) {
}
