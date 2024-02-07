package pl.dudi.invoiceservice.service.impl;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.dudi.invoiceservice.dto.InvoiceDto;
import pl.dudi.invoiceservice.dto.InvoiceRequestDto;
import pl.dudi.invoiceservice.service.InvoiceService;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private static final String CURRENT_MONTH = LocalDate.now().format(DateTimeFormatter.ofPattern("MM_yyyy"));
    @Value("$(temp.invoice.location)")
    private String tempInvoiceCatalog;

    @Override
    public InvoiceDto generateInvoice(InvoiceRequestDto request)  {
        Document document = null;
        try {
            document = preparePdfDocument(request);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Problems generating pdf");
        }

        prepareInvoiceTitle();


        return new InvoiceDto(document);
    }

    private void prepareInvoiceTitle() {
        Table table = new Table(new float[]{3, 1});
        table.addCell(new Cell().add(new Paragraph("Invoice")));

    }

    private Document preparePdfDocument(InvoiceRequestDto request) throws FileNotFoundException {
        Path path = Paths.get(tempInvoiceCatalog + request.getCustomerDetailsDto().getFullName() + CURRENT_MONTH);
        PdfWriter pdfWriter = new PdfWriter(path.toString());
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.setDefaultPageSize(PageSize.A4);
        return new Document(pdfDocument);
    }
}
