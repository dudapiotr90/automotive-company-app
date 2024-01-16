package pl.dudi.clientservice.infrastructure.database.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "order_item")
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;

    private BigDecimal quantity;
    private String productNumber;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

}
