package pl.dudi.orderservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.dudi.basedomains.dto.orders.OrderDto;
import pl.dudi.orderservice.infrastructure.database.entity.OrderEntity;
import pl.dudi.orderservice.model.Order;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,uses = OrderItemMapper.class)
public interface OrderMapper {

    OrderDto mapToOrderDto(Order order);
    Order mapToOrder(OrderDto order);
    OrderEntity mapToOrderEntity(Order order);
    Order mapToOrder(OrderEntity order);


}
