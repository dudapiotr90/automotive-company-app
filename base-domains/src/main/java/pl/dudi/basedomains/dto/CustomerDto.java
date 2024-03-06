package pl.dudi.basedomains.dto;

public record CustomerDto(
    String fullName,
    int customerCode,
    String login,
    String email
) {

}
