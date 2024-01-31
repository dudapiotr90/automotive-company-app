package pl.dudi.orderservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.dudi.basedomains.dto.CustomerDto;
import pl.dudi.basedomains.dto.OrderDto;
import pl.dudi.basedomains.dto.PageRequestDto;
import pl.dudi.basedomains.utils.PageableService;
import pl.dudi.basedomains.utils.UuidGenerator;
import pl.dudi.orderservice.dto.OrderRequestDto;
import pl.dudi.orderservice.dto.OrderResponseMessage;
import pl.dudi.orderservice.infrastructure.database.dao.OrderDao;
import pl.dudi.orderservice.mapper.OrderMapper;
import pl.dudi.orderservice.model.Order;
import pl.dudi.orderservice.service.OrderItemService;
import pl.dudi.orderservice.service.OrderService;
import pl.dudi.orderservice.service.apiclients.AccountServiceAPIClient;
import pl.dudi.orderservice.service.apiclients.ManagementServiceAPIClient;
import pl.dudi.orderservice.service.producer.EmailProducer;

import java.time.OffsetDateTime;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    public static final PageRequestDto DEFAULT_ORDER_HISTORY_REQUEST = new PageRequestDto(1, 10, "desc", "issuedDateTime");

    private final OrderDao orderDAO;
    private final OrderMapper orderMapper;
    private final UuidGenerator generator;
    private final PageableService pageableService;
    private final OrderItemService orderItemService;
    private final EmailProducer emailProducer;
    private final AccountServiceAPIClient accountServiceAPIClient;

    @Override
    public Page<OrderDto> getOrders(int customerCode, PageRequestDto pageRequestDto) {
        Pageable pageable = pageableService.preparePageable(DEFAULT_ORDER_HISTORY_REQUEST, pageRequestDto);
        Page<Order> orders = orderDAO.findOrders(customerCode, pageable);
        return orders.map(orderMapper::mapToOrderDto);
    }

    @Override
    public OrderResponseMessage processOrder(int customerCode, OrderRequestDto orderRequest) {
        CustomerDto customerDto = accountServiceAPIClient.findCustomerAccount(customerCode);
        Order order = orderDAO.addOrderToProcess(customerCode, createOrder(orderRequest));
        String emailResponse = emailProducer.sendOrderProcessingEmail(customerDto, orderMapper.mapToOrderDto(order));
        return new OrderResponseMessage(emailResponse,orderMapper.mapToOrderDto(order));
    }

    private Order createOrder(OrderRequestDto orderRequest) {
        return Order.builder()
            .orderNumber(generator.generateUuid())
            .issuedDateTime(OffsetDateTime.now())
            .comment(orderRequest.getCustomerComment())
            .cancelTill(OffsetDateTime.now().plusDays(7))
            .realized(false)
            .inProgress(true)
            .orderItems(orderItemService.prepareOrderItems(orderRequest.getOrderItems()))
            .build();
    }

}
