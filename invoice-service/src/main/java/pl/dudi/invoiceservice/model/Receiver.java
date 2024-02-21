package pl.dudi.invoiceservice.model;

import pl.dudi.basedomains.dto.Address;

public record Receiver(
    String fullName,
    String email,
    Address deliveryAddress
) {
}
