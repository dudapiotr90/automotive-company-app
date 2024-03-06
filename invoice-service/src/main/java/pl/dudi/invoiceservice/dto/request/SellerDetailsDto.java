package pl.dudi.invoiceservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.dudi.invoiceservice.model.Issuer;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellerDetailsDto {
    private String companyName;
    private String nip;
    private String phoneNumber;
    private String email;
    private Issuer issuer;

    public String printSeller() {
        return companyName + System.lineSeparator()
            + nip + System.lineSeparator()
            + phoneNumber + System.lineSeparator()
            + email;
    }
}
