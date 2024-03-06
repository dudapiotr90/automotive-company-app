package pl.dudi.customerservice.dto.request;

import pl.dudi.basedomains.dto.orders.OrderItemDto;

import java.util.Set;

public record OrderRequestDto(
    String customerComment,
    Set<OrderItemDto> orderItems
) {

}
