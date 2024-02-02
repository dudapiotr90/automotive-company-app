package pl.dudi.orderservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import pl.dudi.basedomains.dto.orders.OrderItemDto;
import pl.dudi.orderservice.infrastructure.database.entity.OrderItemEntity;
import pl.dudi.orderservice.model.OrderItem;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderItemMapper {

    OrderItemEntity mapToOrderItemEntity(OrderItem orderItem);
    OrderItemDto mapToOrderItemDto(OrderItem orderItem);
    OrderItem mapToOrderItem(OrderItemDto orderItem);

    OrderItem mapToOrderItem(OrderItemEntity orderItem);


    @Named("mapOrderItemsToEntity")
    default Set<OrderItemEntity> mapOrderItemsToEntity(Set<OrderItem> orderItems) {
        if (Objects.isNull(orderItems)) {
            return null;
        }
        return orderItems.stream().map(this::mapToOrderItemEntity).collect(Collectors.toSet());

    }

    @Named("mapOrderItemsFromEntity")
    default Set<OrderItem> mapOrderItemsFromEntity(Set<OrderItemEntity> orderItems) {
        if (Objects.isNull(orderItems)) {
            return null;
        }
        return orderItems.stream().map(this::mapToOrderItem).collect(Collectors.toSet());
    }


    @Named("mapOrderItemsToDto")
    default Set<OrderItemEntity> mapOrderItemsToDto(Set<OrderItem> orderItems) {
        if (Objects.isNull(orderItems)) {
            return null;
        }
        return orderItems.stream().map(this::mapToOrderItemEntity).collect(Collectors.toSet());

    }

    @Named("mapOrderItemsFromDto")
    default Set<OrderItem> mapOrderItemsFromDto(Set<OrderItemEntity> orderItems) {
        if (Objects.isNull(orderItems)) {
            return null;
        }
        return orderItems.stream().map(this::mapToOrderItem).collect(Collectors.toSet());
    }
}
