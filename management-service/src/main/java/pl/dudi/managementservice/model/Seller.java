package pl.dudi.managementservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Seller {

    private String companyName;
    private String nip;
    private String phoneNumber;
    private String email;
}
