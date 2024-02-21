package pl.dudi.productionservice.dto;

public record OpinionRequestDto(
    String productNumber,
    int score,
    String description
) {
}
