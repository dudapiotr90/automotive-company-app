package pl.dudi.orderservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.dudi.basedomains.dto.OrderDto;
import pl.dudi.basedomains.dto.PageRequestDto;
import pl.dudi.basedomains.utils.PageableService;
import pl.dudi.orderservice.infrastructure.database.repository.dao.OrderDao;
import pl.dudi.orderservice.mapper.OrderMapper;
import pl.dudi.orderservice.model.Order;
import pl.dudi.orderservice.service.OrderService;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    public static final PageRequestDto DEFAULT_ORDER_HISTORY_REQUEST = new PageRequestDto(1, 10, "desc", "issuedDateTime");

    private final OrderDao orderDAO;
    private final OrderMapper orderMapper;
    private final PageableService pageableService;

    @Override
    public Page<OrderDto> getOrders(int customerCode, PageRequestDto pageRequestDto) {
        Pageable pageable = pageableService.preparePageable(DEFAULT_ORDER_HISTORY_REQUEST, pageRequestDto);
        Page<Order> orders = orderDAO.findOrders(customerCode, pageable);
        return orders.map(orderMapper::mapToOrderDto);
    }
}
