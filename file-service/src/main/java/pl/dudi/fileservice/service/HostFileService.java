package pl.dudi.fileservice.service;

import org.springframework.web.multipart.MultipartFile;
import pl.dudi.fileservice.dto.FileDetailsResponse;
import pl.dudi.fileservice.model.FileRequest;
import pl.dudi.fileservice.model.InvoiceData;

public interface HostFileService {
    FileDetailsResponse saveFile(FileRequest fileRequest);

    FileDetailsResponse updateFile(FileRequest fileRequest, InvoiceData invoiceData);

    MultipartFile fetchInvoice(InvoiceData invoiceData);

    void deleteInvoice(InvoiceData invoiceData);
}
