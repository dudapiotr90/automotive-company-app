package pl.dudi.invoiceservice.dto;

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
    String customerComment;
    OffsetDateTime issuedDateTime;
    OffsetDateTime realizedDateTime;
    Set<OrderItemDto> items;
}
