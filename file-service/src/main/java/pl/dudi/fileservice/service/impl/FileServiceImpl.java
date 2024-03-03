package pl.dudi.fileservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.dudi.fileservice.dto.FileDetailsResponse;
import pl.dudi.fileservice.dto.InvoiceDto;
import pl.dudi.fileservice.infrastructure.database.dao.InvoiceDao;
import pl.dudi.fileservice.model.FileRequest;
import pl.dudi.fileservice.model.InvoiceData;
import pl.dudi.fileservice.service.FileService;
import pl.dudi.fileservice.service.HostFileService;
import pl.dudi.fileservice.service.MultipartFileService;

import java.time.OffsetDateTime;

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
        FileRequest fileRequest = buildFileRequest(file);
        FileDetailsResponse fileDetailsResponse = hostFileService.saveFile(fileRequest);
        invoiceDao.saveInvoiceData(buildInvoiceData(fileDetailsResponse, invoiceDto));
    }

    @Override
    public MultipartFile fetchInvoice(String invoiceNumber) {
        InvoiceData invoiceData = invoiceDao.fetchInvoice(invoiceNumber);
        return hostFileService.fetchInvoice(invoiceData);
    }

    @Override
    public String deleteInvoice(String invoiceNumber) {
        InvoiceData invoiceData = invoiceDao.fetchInvoice(invoiceNumber);
        invoiceDao.deleteInvoice(invoiceData);
        hostFileService.deleteInvoice(invoiceData);
        return "Successfully deleted invoice [%s]".formatted(invoiceNumber);
    }

    @Override
    public void updateInvoice(InvoiceDto invoiceDto) {
        InvoiceData invoiceData = invoiceDao.updateInvoice(invoiceDto.invoiceNumber());
        MultipartFile file = multipartFileService.transferToMultipartFile(invoiceDto);
        FileRequest fileRequest = buildFileRequest(file, invoiceData);
        hostFileService.updateFile(fileRequest, invoiceData);

    }

    private InvoiceData buildInvoiceData(FileDetailsResponse fileDetailsResponse, InvoiceDto invoiceDto) {
        return new InvoiceData(
            fileDetailsResponse.key(),
            fileDetailsResponse.name(),
            invoiceDto.invoiceNumber(),
            fileDetailsResponse.link(),
            fileDetailsResponse.expires()
        );
    }

    private FileRequest buildFileRequest(MultipartFile file) {
        return buildFileRequest(file, null);
    }

    private FileRequest buildFileRequest(MultipartFile file, InvoiceData invoiceData) {
        return new FileRequest(
            file,
            invoiceData != null ? invoiceData.expires() : OffsetDateTime.now().plusDays(2),
            1,
            true
        );
    }
}
