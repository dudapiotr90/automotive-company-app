package pl.dudi.invoiceservice.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pl.dudi.invoiceservice.model.Customer;
import pl.dudi.invoiceservice.model.Issuer;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "invoices")
public class InvoiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long invoiceId;
    private String customerEmail;
    private OffsetDateTime issuedAt;
    private OffsetDateTime completed;
    private String orderNumber;
    private String invoiceNumber;
    private BigDecimal allItems;
    private BigDecimal totalAmount;
}
