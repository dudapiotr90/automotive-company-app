package pl.dudi.managementservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public record SellerDetailsDto(
    String companyName,
    String nip,
    String phoneNumber,
    String email
) {
}
