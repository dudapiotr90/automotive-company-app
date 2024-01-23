package pl.dudi.clientservice.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "order")
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderNumber;
    private OffsetDateTime issuedDateTime;
    private OffsetDateTime realizedDateTime;
    private String comment;

    @OneToMany(mappedBy = "order")
    private Set<OrderItemEntity> orderItems;
}
