package pl.dudi.fileservice.model;

import org.springframework.web.multipart.MultipartFile;

import java.time.OffsetDateTime;

public record FileRequest(
    MultipartFile file,
    OffsetDateTime expires,
    int maxDownloads,
    boolean autoDelete
) {
}
