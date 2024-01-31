package pl.dudi.orderservice.model.rabbitmqmessage;

import pl.dudi.basedomains.dto.CustomerDto;
import pl.dudi.basedomains.dto.OrderDto;

public record CustomerOrderMessage(CustomerDto customer, OrderDto orderDto) {
}
