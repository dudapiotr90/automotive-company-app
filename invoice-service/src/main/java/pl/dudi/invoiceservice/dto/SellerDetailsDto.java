package pl.dudi.invoiceservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellerDetailsDto {
    private String companyName;
    private String nip;
    private String phoneNumber;
    private String email;

    public String printSeller() {
        return companyName + System.lineSeparator()
            + nip + System.lineSeparator()
            + phoneNumber + System.lineSeparator()
            + email;
    }
}
