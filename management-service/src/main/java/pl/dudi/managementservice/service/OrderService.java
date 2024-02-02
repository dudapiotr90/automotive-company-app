package pl.dudi.managementservice.service;

import pl.dudi.basedomains.dto.orders.OrderDto;

import java.util.List;

public interface OrderService {
    OrderDto showOrder(String orderNumber);

    List<OrderDto> showOrdersToProcess(int managerCode, String status);
}
