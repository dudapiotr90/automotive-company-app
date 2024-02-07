package pl.dudi.managementservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.dudi.basedomains.dto.orders.OrderItemDto;

import java.time.OffsetDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsDto {

    String orderNumber;
    OffsetDateTime issuedDateTime;
    OffsetDateTime realizedDateTime;
    Set<OrderItemDto> items;
}
