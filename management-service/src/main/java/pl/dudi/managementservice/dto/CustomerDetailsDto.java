package pl.dudi.managementservice.dto;

public record CustomerDetailsDto(
    String fullName,
    String email,
    long customerCode
) {

}
