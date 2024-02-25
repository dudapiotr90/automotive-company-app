package pl.dudi.productionservice.dto;

import java.time.OffsetDateTime;

public record OpinionResponse(
    int score,
    String description,
    OffsetDateTime submitted
) {
}
