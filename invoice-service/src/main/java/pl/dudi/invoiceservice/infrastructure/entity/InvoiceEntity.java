package pl.dudi.invoiceservice.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@Builder
@Entity
@Table(name = "invoice")
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerEmail;
    private OffsetDateTime issuedAt;
    private OffsetDateTime completed;
    private String orderNumber;
    private String invoiceNumber;
    private BigDecimal allItems;
    private BigDecimal totalAmount;

    @ManyToOne
    @JoinColumn(name = "issuer_id")
    private IssuerEntity issuer;
}
