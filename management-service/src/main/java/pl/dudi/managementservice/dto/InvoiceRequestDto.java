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

    private CustomerDetailsDto customerDetails;
    private OrderDetailsDto orderDetails;
    private SellerDetailsDto sellerDetails;
}
