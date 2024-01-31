package pl.dudi.orderservice.model.rabbitmqmessage;

import pl.dudi.basedomains.dto.CustomerDto;
import pl.dudi.orderservice.dto.OrderRequestDto;

public record CustomerOrderMessage(CustomerDto customer, OrderRequestDto orderRequest) {
}
