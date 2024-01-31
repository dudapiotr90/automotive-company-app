package pl.dudi.orderservice.model;

import lombok.Builder;
import lombok.Value;
import lombok.With;

import java.time.OffsetDateTime;
import java.util.Set;

@With
@Value
@Builder
public class Order {

     String orderNumber;
     OffsetDateTime issuedDateTime;
     OffsetDateTime realizedDateTime;
     OffsetDateTime cancelTill;
     String comment;
     Boolean realized;
     Boolean inProgress;
     Set<OrderItem> orderItems;
}
