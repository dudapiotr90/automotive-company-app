package pl.dudi.customerservice.model;

public record OpinionRequest(
    String productNumber,
    int score,
    String description
) {
}
