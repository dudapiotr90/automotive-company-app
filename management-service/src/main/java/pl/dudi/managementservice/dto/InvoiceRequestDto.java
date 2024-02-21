package pl.dudi.managementservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceRequestDto {

    private CustomerDetailsDto customerDetailsDto;
    private OrderDetailsDto orderDetailsDto;
    private SellerDetailsDto sellerDetailsDto;
}
