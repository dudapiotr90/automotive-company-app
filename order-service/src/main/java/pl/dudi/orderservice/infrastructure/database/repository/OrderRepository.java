package pl.dudi.orderservice.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import pl.dudi.orderservice.infrastructure.database.dao.OrderDao;
import pl.dudi.orderservice.infrastructure.database.entity.OrderEntity;
import pl.dudi.orderservice.infrastructure.database.repository.jpa.OrderJpaRepository;
import pl.dudi.orderservice.mapper.OrderMapper;
import pl.dudi.orderservice.model.Order;
import pl.dudi.orderservice.model.Status;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Repository
@AllArgsConstructor
public class OrderRepository implements OrderDao {

    private final OrderJpaRepository orderJpaRepository;
    private final OrderMapper orderMapper;


    @Override
    public Page<Order> findOrders(int customerCode, Pageable pageRequestDto, Status status) {
        if (Objects.isNull(status)) {
            status = Status.REALIZED;
        }
        return orderJpaRepository.findByCustomerCodeAndStatus(customerCode,status,pageRequestDto)
            .map(orderMapper::mapToOrder);
    }

    @Override
    public Order addOrderToProcess(int customerDto, Order order) {
        OrderEntity orderEntity = orderMapper.mapToOrderEntity(order);
        OrderEntity saved = orderJpaRepository.save(orderEntity);
        return orderMapper.mapToOrder(saved);
    }

    @Override
    public Optional<Order> findOrderByOrderNumber(String orderNumber) {
        return orderJpaRepository.findByOrderNumber(orderNumber)
            .map(orderMapper::mapToOrder);
    }

    @Override
    public List<Order> findOrdersByStatus(Status status) {
        return orderJpaRepository.findByStatus(status).stream()
            .map(orderMapper::mapToOrder)
            .toList();
    }
}
