package pl.dudi.orderservice.infrastructure.database.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.dudi.orderservice.model.Order;
import pl.dudi.orderservice.model.Status;

import java.util.List;
import java.util.Optional;

public interface OrderDao {
    Page<Order> findOrders(int customerCode, Pageable pageable);

    Order addOrderToProcess(int customerDto, Order order);

    Optional<Order> findOrderByOrderNumber(String orderNumber);

    List<Order> findOrdersByStatus(Status status);
}
