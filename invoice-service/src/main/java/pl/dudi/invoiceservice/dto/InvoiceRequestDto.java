package pl.dudi.invoiceservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceRequestDto {
    private OrderDetailsDto orderDetailsDto;
    private CustomerDetailsDto customerDetailsDto;
    private SellerDetailsDto sellerDetailsDto;
}
