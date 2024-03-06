package pl.dudi.orderservice.service;

import org.springframework.data.domain.Page;
import pl.dudi.basedomains.dto.orders.OrderDto;
import pl.dudi.basedomains.dto.PageRequestDto;
import pl.dudi.orderservice.dto.OrderRequestDto;
import pl.dudi.orderservice.dto.OrderResponseMessage;
import pl.dudi.orderservice.model.Status;

import java.util.List;

public interface OrderService {

    PageRequestDto DEFAULT_ORDER_HISTORY_REQUEST = new PageRequestDto(1, 10, "desc", "issuedDateTime");
    Page<OrderDto> getOrders(int customerCode, PageRequestDto pageRequestDto, Status status);

    OrderDto processOrder(int customerCode, OrderRequestDto orderRequest);

    OrderDto getOrder(String orderNumber);

    List<OrderDto> getOrdersToProcess(String status);

    String cancelOrder(String orderNumber);

    void setOrderToProcess();

}
