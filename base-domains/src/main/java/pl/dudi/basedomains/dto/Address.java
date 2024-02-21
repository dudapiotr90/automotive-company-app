package pl.dudi.basedomains.dto;

public record Address(
    Integer addressId,
    String city,
    String postalCode,
    String street,
    String residenceNumber

) {

}
