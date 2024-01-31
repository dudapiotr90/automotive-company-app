package pl.dudi.orderservice.service;

import pl.dudi.orderservice.dto.OrderItemDto;
import pl.dudi.orderservice.model.OrderItem;

import java.util.Set;

public interface OrderItemService {
    Set<OrderItem> prepareOrderItems(Set<OrderItemDto> orderItems);
}
