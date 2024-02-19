package pl.dudi.invoiceservice.service.impl;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.dudi.invoiceservice.dto.InvoiceRequestDto;
import pl.dudi.invoiceservice.model.Invoice;
import pl.dudi.invoiceservice.model.PdfFile;
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
public class InvoiceGeneratorImpl implements InvoiceGenerator {

    public static final String PDF_FORMAT = ".pdf";
    public static final String GENERATED = "generated";


    private final InvoiceTitleGenerator invoiceTitleGenerator;
    private final InvoiceInfoGenerator invoiceInfoGenerator;
    private final InvoiceItemListGenerator invoiceItemListGenerator;
    private final InvoiceSummaryGenerator invoiceSummaryGenerator;
    private final InvoiceCommentsGenerator invoiceCommentsGenerator;
    private final InvoiceSignGeneratorImpl invoiceSignGenerator;

    @Value("$(temp.invoice.location)")
    private String tempInvoiceCatalog;

    @Override
    public PdfFile generateInvoice(InvoiceRequestDto request, Invoice invoice) {
        Document document;
        Path path;
        try {
            path = getInvoicePath(invoice);
            document = preparePdfDocument(path,invoice);
            invoiceTitleGenerator.prepareInvoiceTitle(document, invoice);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Problems generating pdf");
        } catch (IOException e) {
            throw new RuntimeException("Couldn't create a resource");
        }
        invoiceInfoGenerator.prepareInfoSection(request, document);
        invoiceItemListGenerator.prepareProductList(document, request.getOrderDetailsDto());
        invoiceSummaryGenerator.prepareSummary(document, invoice);
        invoiceCommentsGenerator.prepareComments(document, request.getOrderDetailsDto());
        invoiceSignGenerator.addSign(document);

        document.close();
        return new PdfFile(document,path);
    }

    private Document preparePdfDocument(Path path, Invoice invoice) throws IOException {
        PdfWriter pdfWriter = new PdfWriter(path.toString());
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.setDefaultPageSize(PageSize.A4);
        return new Document(pdfDocument);
    }

    private Path getInvoicePath(Invoice invoice) throws IOException {
        Path directory = Files.createDirectories(Paths.get(tempInvoiceCatalog));
        return Paths.get(tempInvoiceCatalog + invoice.invoiceNumber()+GENERATED+PDF_FORMAT);
    }

}
