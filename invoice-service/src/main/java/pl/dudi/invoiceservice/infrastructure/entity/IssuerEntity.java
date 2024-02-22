package pl.dudi.invoiceservice.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "issuers")
public class IssuerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long issuer_id;

    private String fullName;
    private String email;

    @OneToMany(mappedBy = "issuer")
    private Set<InvoiceEntity> invoices;
}
