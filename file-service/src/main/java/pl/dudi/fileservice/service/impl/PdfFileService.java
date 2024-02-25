package pl.dudi.fileservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.dudi.fileservice.dto.InvoiceDto;
import pl.dudi.fileservice.model.PdfFile;
import pl.dudi.fileservice.service.MultipartFileService;

@Slf4j
@Service
public class PdfFileService implements MultipartFileService {

    @Override
    public MultipartFile transferToMultipartFile(InvoiceDto invoiceDto) {
        return new PdfFile(invoiceDto.invoiceNumber(),"Invoice", invoiceDto.file());
    }
}
