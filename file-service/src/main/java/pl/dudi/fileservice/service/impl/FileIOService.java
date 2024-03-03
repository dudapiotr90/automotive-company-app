package pl.dudi.fileservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.multipart.MultipartFile;
import pl.dudi.fileservice.dto.FileDetailsResponse;
import pl.dudi.fileservice.exception.DocumentNotFoundException;
import pl.dudi.fileservice.model.FileRequest;
import pl.dudi.fileservice.model.InvoiceData;
import pl.dudi.fileservice.model.PdfFile;
import pl.dudi.fileservice.service.HostFileService;

import java.nio.file.NoSuchFileException;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileIOService implements HostFileService {

    private static final String BASE_URL = "https://file.io/";
    private static final String GET_FILE_BY_KEY = "{key}";
    private final RestClient restClient;


    @Override
    public FileDetailsResponse saveFile(FileRequest fileRequest) {
        return restClient.post()
            .uri(BASE_URL)
            .contentType(MediaType.MULTIPART_FORM_DATA)
            .body(fileRequest)
            .retrieve()
            .onStatus(HttpStatusCode::is4xxClientError,
                (request, response) -> {
                    throw new FileUploadException("Error uploading a file");
                })
            .body(FileDetailsResponse.class);

    }

    @Override
    public FileDetailsResponse updateFile(FileRequest fileRequest, InvoiceData invoiceData) {
        return restClient.patch()
            .uri(BASE_URL+GET_FILE_BY_KEY,invoiceData.key())
            .contentType(MediaType.MULTIPART_FORM_DATA)
            .body(fileRequest)
            .retrieve()
            .onStatus(HttpStatusCode::is4xxClientError,
                (request, response) -> {
                    throw new FileUploadException("Error uploading a file");
                })
            .body(FileDetailsResponse.class);
    }

    @Override
    public MultipartFile fetchInvoice(InvoiceData invoiceData) {
        return restClient.get()
            .uri(BASE_URL + GET_FILE_BY_KEY, invoiceData.key())
            .accept(MediaType.APPLICATION_PDF)
            .retrieve()
            .onStatus(statusCode -> statusCode.isSameCodeAs(HttpStatus.NOT_FOUND),
                (request, response) -> {
                throw new DocumentNotFoundException("Invoice [%s] not present. If it was downloaded before its automatically removed"
                    .formatted(invoiceData.name()));
            })
            .body(PdfFile.class);
    }

    @Override
    public void deleteInvoice(InvoiceData invoiceData) {
        restClient.delete()
            .uri(BASE_URL + GET_FILE_BY_KEY, invoiceData.key())
            .retrieve()
            .onStatus(statusCode -> statusCode.isSameCodeAs(HttpStatus.FORBIDDEN),
                (request, response) -> {
                    throw new NoSuchFileException("File doesn't exist");
                });
    }
}
