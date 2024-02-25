package pl.dudi.fileservice.service;

import org.springframework.web.multipart.MultipartFile;
import pl.dudi.fileservice.dto.InvoiceDto;

public interface MultipartFileService {
    MultipartFile transferToMultipartFile(InvoiceDto invoiceDto);
}
