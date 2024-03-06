package pl.dudi.orderservice.infrastructure.database.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.dudi.orderservice.model.Order;
import pl.dudi.orderservice.model.Status;

import java.time.OffsetDateTime;
import java.util.List;

public interface OrderDao {
    Page<Order> findOrders(int customerCode, Pageable pageable, Status status);

    Order addOrder(int customerDto, Order order);

    Order findOrderByOrderNumber(String orderNumber);

    List<Order> findOrdersByStatus(Status status);

    void deleteOrder(String orderNumber);

    void cancelOrder(String orderNumber, Status status);

    void addOrdersToProcess(Status currentStatus, Status newStatus, OffsetDateTime time);
}
