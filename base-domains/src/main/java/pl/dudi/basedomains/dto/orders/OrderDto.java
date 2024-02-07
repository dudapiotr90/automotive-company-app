package pl.dudi.basedomains.dto.orders;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    String orderNumber;
    OffsetDateTime issuedDateTime;
    OffsetDateTime realizedDateTime;
    String comment;
    String status;
    OffsetDateTime cancelTill;
    Set<OrderItemDto> items;
    int customerCode;
}
