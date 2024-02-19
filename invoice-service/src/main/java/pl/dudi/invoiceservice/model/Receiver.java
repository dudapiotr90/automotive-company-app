package pl.dudi.invoiceservice.model;

public record Receiver(
    String fullName,
    String email,
    Address deliveryAddress
) {
}
