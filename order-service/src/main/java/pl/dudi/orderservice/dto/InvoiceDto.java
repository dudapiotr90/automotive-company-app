package pl.dudi.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.dudi.basedomains.dto.CustomerDto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDto {

    private String invoiceNumber;
    private OffsetDateTime issuedAt;
    private CustomerDto customer;
    private SellerDto seller;
    private String comments;
    private List<OrderItemDto> items;
    private BigDecimal totalPrice;
}
