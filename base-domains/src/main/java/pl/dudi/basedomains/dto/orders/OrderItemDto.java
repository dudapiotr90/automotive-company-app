package pl.dudi.basedomains.dto.orders;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDto {

    private String productName;
    private String productNumber;
    private BigDecimal quantity;
    private BigDecimal price;
    private BigDecimal totalCost;
}
