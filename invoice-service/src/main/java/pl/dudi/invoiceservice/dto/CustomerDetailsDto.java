package pl.dudi.invoiceservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDetailsDto {

    private String fullName;
    private String email;
    private long customerCode;

    public String printCustomer() {
        return fullName+System.lineSeparator()+email;
    }
}
