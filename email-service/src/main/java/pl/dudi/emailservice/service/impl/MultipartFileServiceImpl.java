package pl.dudi.emailservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.dudi.emailservice.dto.InvoiceDto;
import pl.dudi.emailservice.model.PdfMultipartFile;
import pl.dudi.emailservice.service.MultipartFileService;

@Service
public class MultipartFileServiceImpl implements MultipartFileService {
    @Override
    public MultipartFile createMultipartFile(InvoiceDto invoice) {
        return new PdfMultipartFile(invoice.invoiceNumber(), "Invoice", invoice.attachment());
    }
}
