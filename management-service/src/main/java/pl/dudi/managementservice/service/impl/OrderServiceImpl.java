package pl.dudi.managementservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dudi.basedomains.dto.orders.OrderDto;
import pl.dudi.managementservice.service.OrderService;
import pl.dudi.managementservice.service.apiclients.OrderServiceApiClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderServiceApiClient orderServiceApiClient;

    @Override
    public OrderDto showOrder(String orderNumber) {
        return orderServiceApiClient.showOrder(orderNumber);
    }

    @Override
    public List<OrderDto> showOrdersToProcess(int managerCode, String status) {
        return orderServiceApiClient.showOrdersToProcess(managerCode,status);
    }
}
