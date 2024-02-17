package pl.dudi.invoiceservice.service.impl;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.dudi.invoiceservice.dto.InvoiceDto;
import pl.dudi.invoiceservice.dto.InvoiceRequestDto;
import pl.dudi.invoiceservice.service.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
@RequiredArgsConstructor
public class InvoiceGeneratorImpl implements InvoiceGenerator{

    private static final String PDF_FORMAT = ".pdf";
    private static final String CURRENT_MONTH = LocalDate.now().format(DateTimeFormatter.ofPattern("MM_yyyy"));


    private final InvoiceTitleGenerator invoiceTitleGenerator;
    private final InvoiceInfoGenerator invoiceInfoGenerator;
    private final InvoiceItemListGenerator invoiceItemListGenerator;
    private final InvoiceSummaryGenerator invoiceSummaryGenerator;
    private final InvoiceCommentsGenerator invoiceCommentsGenerator;
    private final InvoiceSignGeneratorImpl invoiceSignGenerator;

    @Value("$(temp.invoice.location)")
    private String tempInvoiceCatalog;

    @Override
    public Document generateInvoice(InvoiceRequestDto request, InvoiceDto invoice) {
        Document document = null;
        try {
            document = preparePdfDocument(request);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Problems generating pdf");
        } catch (IOException e) {
            throw new RuntimeException("Couldn't create catalog");
        }

        invoiceTitleGenerator.prepareInvoiceTitle(document);
        invoiceInfoGenerator.prepareInfoSection(request,document);

        return document;
    }

    private Document preparePdfDocument(InvoiceRequestDto request) throws IOException {
        Path directory = Files.createDirectories(Paths.get(tempInvoiceCatalog));
        Path path = Paths.get(tempInvoiceCatalog + request.getCustomerDetailsDto().getFullName() + CURRENT_MONTH);
        PdfWriter pdfWriter = new PdfWriter(path.toString());
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.setDefaultPageSize(PageSize.A4);
        return new Document(pdfDocument);
    }
}
