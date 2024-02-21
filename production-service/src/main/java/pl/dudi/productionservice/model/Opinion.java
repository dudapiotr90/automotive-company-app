package pl.dudi.productionservice.model;


import java.time.OffsetDateTime;

public record Opinion(
    String comment,
    int score,
    OffsetDateTime issuedAt,
    Product product
) {

}
