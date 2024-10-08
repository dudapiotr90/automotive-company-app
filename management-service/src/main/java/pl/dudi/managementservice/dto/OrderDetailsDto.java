package pl.dudi.managementservice.dto;

import pl.dudi.basedomains.dto.orders.OrderItemDto;

import java.time.OffsetDateTime;
import java.util.Set;

public record OrderDetailsDto(
    String orderNumber,
    String customerComment,
    OffsetDateTime issuedDateTime,
    OffsetDateTime realizedDateTime,
    Set<OrderItemDto> items
) {






}
