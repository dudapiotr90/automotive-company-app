package pl.dudi.orderservice.service;

import org.springframework.data.domain.Page;
import pl.dudi.basedomains.dto.OrderDto;
import pl.dudi.basedomains.dto.PageRequestDto;
import pl.dudi.orderservice.dto.OrderRequestDto;
import pl.dudi.orderservice.dto.OrderResponseMessage;

public interface OrderService {
    Page<OrderDto> getOrders(int customerCode, PageRequestDto pageRequestDto);

    OrderResponseMessage processOrder(int customerCode, OrderRequestDto orderRequest);
}
