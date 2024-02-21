package pl.dudi.invoiceservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.dudi.invoiceservice.dto.InvoiceDto;
import pl.dudi.invoiceservice.dto.InvoiceRequestDto;
import pl.dudi.invoiceservice.model.Invoice;
import pl.dudi.invoiceservice.model.PdfFile;
import pl.dudi.invoiceservice.service.InvoiceDetailsService;
import pl.dudi.invoiceservice.service.InvoiceGenerator;
import pl.dudi.invoiceservice.service.InvoiceService;

import java.io.IOException;
import java.nio.file.Files;

@Slf4j
@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {


    private final InvoiceGenerator invoiceGenerator;
    private final InvoiceDetailsService invoiceDetailsService;

    @Override
    public InvoiceDto processInvoice(InvoiceRequestDto request) {
        Invoice invoice = invoiceDetailsService.prepareInvoiceDetails(request);
        PdfFile pdf = invoiceGenerator.generateInvoice(request, invoice);

        return prepareInvoiceDto(pdf,invoice);
    }

    private static InvoiceDto prepareInvoiceDto(PdfFile pdf, Invoice invoice) {
        byte[] fileAsByteArray;
        try {
            fileAsByteArray = Files.readAllBytes(pdf.path());
            return new InvoiceDto(fileAsByteArray,invoice.invoiceNumber());
        } catch (IOException e) {
            log.error("Coping file failed");
            throw new RuntimeException("Couldn't copy file");
        }
    }
}
