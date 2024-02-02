package pl.dudi.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.dudi.basedomains.dto.orders.OrderItemDto;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDto {

    private String customerComment;
    private Set<OrderItemDto> orderItems;

}
