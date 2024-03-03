package pl.dudi.fileservice.model;

public record ErrorResponseMessage(
    int status,
    String message
) {
}
