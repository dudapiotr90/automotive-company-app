package pl.dudi.fileservice.service;

import org.springframework.web.multipart.MultipartFile;
import pl.dudi.fileservice.dto.InvoiceDto;
import pl.dudi.fileservice.model.PdfFile;

public interface FileService {
    void saveInvoice(InvoiceDto invoiceDto);

    MultipartFile fetchInvoice(String invoiceNumber);

    String deleteInvoice(String invoiceNumber);

    void updateInvoice(InvoiceDto invoiceDto);
}
