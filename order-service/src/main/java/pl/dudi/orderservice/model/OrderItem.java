package pl.dudi.orderservice.model;

import lombok.Builder;
import lombok.Value;
import lombok.With;

import java.math.BigDecimal;

@With
@Value
@Builder
public class OrderItem {

    Long orderItemId;
    BigDecimal quantity;
    String productNumber;
    String comment;
    Order order;
}
