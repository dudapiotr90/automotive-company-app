package pl.dudi.orderservice.model.rabbitmqmessage;

import pl.dudi.basedomains.dto.CustomerDto;
import pl.dudi.basedomains.dto.orders.OrderDto;

public record CustomerOrderMessage(CustomerDto customer, OrderDto orderDto) {
}
