package pl.dudi.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.dudi.basedomains.dto.OrderDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseMessage {

    private String emailMessage;
    private OrderDto orderDto;
}
