package pl.dudi.fileservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.dudi.fileservice.dto.FileDetailsResponse;
import pl.dudi.fileservice.dto.InvoiceDto;
import pl.dudi.fileservice.infrastructure.database.dao.InvoiceDao;
import pl.dudi.fileservice.model.InvoiceData;
import pl.dudi.fileservice.service.FileService;
import pl.dudi.fileservice.service.HostFileService;
import pl.dudi.fileservice.service.MultipartFileService;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final HostFileService hostFileService;
    private final MultipartFileService multipartFileService;
    private final InvoiceDao invoiceDao;

    @Override
    public void saveInvoice(InvoiceDto invoiceDto) {
        MultipartFile file = multipartFileService.transferToMultipartFile(invoiceDto);
        FileDetailsResponse fileDetailsResponse = hostFileService.sendFileToHosting(file);
        invoiceDao.saveInvoiceData(buildInvoiceData(fileDetailsResponse));
    }

    private InvoiceData buildInvoiceData(FileDetailsResponse fileDetailsResponse) {
        return new InvoiceData(
            fileDetailsResponse.key(),
            fileDetailsResponse.name(),
            fileDetailsResponse.link(),
            fileDetailsResponse.expires()
        );
    }
}
