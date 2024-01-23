package pl.dudi.accountservice.infrastructure.database.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(unique = true)
    private int customerCode;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private AccountEntity account;


}
