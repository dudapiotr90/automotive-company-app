package pl.dudi.managementservice.model;

import pl.dudi.managementservice.dto.Invoice;

public record EmailDetails(
    Invoice invoice,
    String email
) {
}
