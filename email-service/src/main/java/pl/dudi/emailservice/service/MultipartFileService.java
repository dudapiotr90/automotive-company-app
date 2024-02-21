package pl.dudi.emailservice.service;

import org.springframework.web.multipart.MultipartFile;
import pl.dudi.emailservice.dto.InvoiceDto;

public interface MultipartFileService {
    MultipartFile createMultipartFile(InvoiceDto attachment);
}
