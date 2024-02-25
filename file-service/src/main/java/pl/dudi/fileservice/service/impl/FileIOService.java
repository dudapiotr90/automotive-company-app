package pl.dudi.fileservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.multipart.MultipartFile;
import pl.dudi.fileservice.dto.FileDetailsResponse;
import pl.dudi.fileservice.dto.InvoiceDto;
import pl.dudi.fileservice.service.HostFileService;

import java.time.OffsetDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileIOService implements HostFileService {

    private static final int MAX_DOWNLOADS = 1;
    private static final String BASE_URL = "https://file.io/";
    private final RestClient restClient;


    @Override
    public FileDetailsResponse sendFileToHosting(MultipartFile file) {
        return restClient.post()
            .uri(BASE_URL, uriBuilder -> uriBuilder
                .queryParam("expires", OffsetDateTime.now().plusDays(10))
                .queryParam("maxDownloads", MAX_DOWNLOADS)
                .queryParam("autoDelete", true)
                .build()
            )
            .contentType(MediaType.MULTIPART_FORM_DATA)
            .body(file)
            .retrieve()
            .onStatus(HttpStatusCode::is4xxClientError,
                (request, response) -> {
                    throw new FileUploadException("Error uploading a file");
                })
            .body(FileDetailsResponse.class);

    }
}
