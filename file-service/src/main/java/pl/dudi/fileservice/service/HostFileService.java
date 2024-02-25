package pl.dudi.fileservice.service;

import org.springframework.web.multipart.MultipartFile;
import pl.dudi.fileservice.dto.FileDetailsResponse;
import pl.dudi.fileservice.dto.InvoiceDto;

public interface HostFileService {
    FileDetailsResponse sendFileToHosting(MultipartFile file);
}
