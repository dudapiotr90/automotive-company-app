package pl.dudi.orderservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.dudi.orderservice.dto.OrderItemDto;
import pl.dudi.orderservice.mapper.OrderItemMapper;
import pl.dudi.orderservice.model.OrderItem;
import pl.dudi.orderservice.service.OrderItemService;

import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

    @Override
    public Set<OrderItem> prepareOrderItems(Set<OrderItemDto> orderItems) {
        return orderItems.stream()
            .map(oi -> OrderItem
                .builder()
                .quantity(oi.getQuantity())
                .productNumber(oi.getProductNumber())
                .build())
            .collect(Collectors.toSet());
    }
}
