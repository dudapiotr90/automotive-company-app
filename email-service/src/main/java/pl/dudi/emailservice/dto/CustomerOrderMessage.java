package pl.dudi.emailservice.dto;

import pl.dudi.basedomains.dto.CustomerDto;

public record CustomerOrderMessage(CustomerDto customer, OrderRequestDto orderRequest) {
}
