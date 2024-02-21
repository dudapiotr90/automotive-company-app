package pl.dudi.managementservice.model;

import pl.dudi.managementservice.dto.InvoiceDto;

public record EmailDetails(
    InvoiceDto invoice,
    String email
) {
}
