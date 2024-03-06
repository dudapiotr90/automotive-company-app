package pl.dudi.orderservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl.dudi.basedomains.dto.CustomerDto;
import pl.dudi.basedomains.dto.PageRequestDto;
import pl.dudi.basedomains.dto.orders.OrderDto;
import pl.dudi.basedomains.utils.PageableService;
import pl.dudi.orderservice.dto.OrderRequestDto;
import pl.dudi.orderservice.infrastructure.database.dao.OrderDao;
import pl.dudi.orderservice.mapper.OrderMapper;
import pl.dudi.orderservice.model.Order;
import pl.dudi.orderservice.model.Status;
import pl.dudi.orderservice.service.OrderItemService;
import pl.dudi.orderservice.service.OrderService;
import pl.dudi.orderservice.service.apiclients.AccountServiceAPIClient;
import pl.dudi.orderservice.service.producer.EmailProducer;
import pl.dudi.orderservice.utility.UUIDGenerator;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {


    private final OrderDao orderDAO;
    private final OrderMapper orderMapper;
    private final UUIDGenerator generator;
    private final PageableService pageableService;
    private final OrderItemService orderItemService;
    private final EmailProducer emailProducer;
    private final AccountServiceAPIClient accountServiceAPIClient;

    @Override
    public Page<OrderDto> getOrders(int customerCode, PageRequestDto pageRequestDto, Status status) {
        Pageable pageable = pageableService.preparePageable(DEFAULT_ORDER_HISTORY_REQUEST, pageRequestDto);
        Page<Order> orders = orderDAO.findOrders(customerCode, pageable,status);
        return orders.map(orderMapper::mapToOrderDto);
    }

    @Override
    public OrderDto processOrder(int customerCode, OrderRequestDto orderRequest) {
        CustomerDto customerDto = accountServiceAPIClient.findCustomerAccount(customerCode);
        Order order = orderDAO.addOrder(customerCode, createOrder(orderRequest,customerCode));
        emailProducer.sendOrderProcessingEmail(customerDto, orderMapper.mapToOrderDto(order));
        return orderMapper.mapToOrderDto(order);
    }

    @Override
    public OrderDto getOrder(String orderNumber) {
        Order order = orderDAO.findOrderByOrderNumber(orderNumber);
        return orderMapper.mapToOrderDto(order);
    }

    @Override
    public List<OrderDto> getOrdersToProcess(String status) {
        List<Order> orders = orderDAO.findOrdersByStatus(Status.valueOf(status.toUpperCase()));
        return orders.stream()
            .map(orderMapper::mapToOrderDto)
            .toList();
    }

    @Override
    public String cancelOrder(String orderNumber) {
        Order order = orderDAO.findOrderByOrderNumber(orderNumber);
        if (order.getCancelTill().isAfter(OffsetDateTime.now())) {
            orderDAO.cancelOrder(orderNumber,Status.CANCELED);
            return "Order cancelled successfully";
        }
        return "Order is already in production";
    }

    @Scheduled(cron = "0 0 6,10,14 * * *")
    @Override
    public void setOrderToProcess() {
        log.info("Adding orders to process {}", Instant.now());
        orderDAO.addOrdersToProcess(Status.ISSUED, Status.IN_PROGRESS, OffsetDateTime.now());
    }

    private Order createOrder(OrderRequestDto orderRequest, int customerCode) {
        return Order.builder()
            .orderNumber(generator.generateUuid())
            .issuedDateTime(OffsetDateTime.now())
            .comment(orderRequest.getCustomerComment())
            .cancelTill(OffsetDateTime.now().plusDays(7))
            .status(Status.ISSUED)
            .orderItems(orderItemService.prepareOrderItems(orderRequest.getOrderItems()))
            .customerCode(customerCode)
            .build();
    }

}
