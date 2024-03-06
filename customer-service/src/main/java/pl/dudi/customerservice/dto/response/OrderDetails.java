package pl.dudi.customerservice.dto.response;

import pl.dudi.basedomains.dto.orders.OrderItemDto;

import java.time.OffsetDateTime;
import java.util.Set;

public record OrderDetails(

    String orderNumber,
    OffsetDateTime issuedDateTime,
    OffsetDateTime realizedDateTime,
    String comment,
    String status,
    OffsetDateTime cancelTill,
    Set<OrderItemDto> items
) {
}
