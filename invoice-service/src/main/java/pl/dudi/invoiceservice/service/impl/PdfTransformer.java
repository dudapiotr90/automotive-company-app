package pl.dudi.invoiceservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.dudi.invoiceservice.dto.response.InvoiceFile;
import pl.dudi.invoiceservice.model.Invoice;
import pl.dudi.invoiceservice.model.PdfFile;
import pl.dudi.invoiceservice.service.DocumentTransformer;

import java.io.IOException;
import java.nio.file.Files;

@Slf4j
@Service
public class PdfTransformer implements DocumentTransformer {

    public InvoiceFile prepareInvoiceDto(PdfFile pdf, Invoice invoice) {
        byte[] fileAsByteArray;
        try {
            fileAsByteArray = Files.readAllBytes(pdf.path());
            return new InvoiceFile(fileAsByteArray,invoice.invoiceNumber());
        } catch (IOException e) {
            log.error("Coping file failed");
            throw new RuntimeException("Couldn't copy file");
        }
    }

}
