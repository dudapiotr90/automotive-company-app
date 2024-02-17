package pl.dudi.invoiceservice.dto;

import pl.dudi.invoiceservice.model.Customer;
import pl.dudi.invoiceservice.model.Issuer;
import pl.dudi.invoiceservice.model.Receiver;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record InvoiceDto(
    Issuer issuer,
    Customer customer,
    Receiver receiver,
    OffsetDateTime issuedAt,
    OffsetDateTime completed,
    String orderNumber,
    BigDecimal totalAmount
) {
}
