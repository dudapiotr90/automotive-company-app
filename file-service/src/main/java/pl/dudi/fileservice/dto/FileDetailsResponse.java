package pl.dudi.fileservice.dto;


import java.time.OffsetDateTime;

public record FileDetailsResponse(
    boolean success,
    int status,
    String id,
    String key,
    String name,
    String link,
    OffsetDateTime expires
) {
}
