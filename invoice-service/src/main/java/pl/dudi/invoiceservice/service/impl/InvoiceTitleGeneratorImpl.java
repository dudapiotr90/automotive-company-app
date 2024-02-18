package pl.dudi.invoiceservice.service.impl;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.canvas.draw.SolidLine;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.properties.TextAlignment;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.dudi.invoiceservice.dto.InvoiceDto;
import pl.dudi.invoiceservice.service.InvoiceTitleGenerator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class InvoiceTitleGeneratorImpl implements InvoiceTitleGenerator {

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final float PAGE_WIDTH = PageSize.A4.getWidth();


    @Value("$(file.logo)")
    private String logo;

    @Override
    public Document prepareInvoiceTitle(Document document, InvoiceDto invoice) throws IOException {
        float[] columnWidths = {0.67f * PAGE_WIDTH, 0.33f * PAGE_WIDTH};
        Table table = new Table(columnWidths);
        ImageData png = createLogo();
        table.addCell(new Cell().add(new Image(png)).setBorder(Border.NO_BORDER));

        Table nestedTable = createNestedTable(invoice);

        SolidLine line = new SolidLine(2);
        line.setColor(ColorConstants.GRAY);

        table.addCell(new Cell().add(nestedTable).setBorder(Border.NO_BORDER));
        document.add(table);
        document.add(new LineSeparator(line).setMargins(10, 0, 10, 0));
        return document;
    }

    private ImageData createLogo() throws IOException {
        ImageData png = ImageDataFactory.createPng(Files.readAllBytes(Paths.get(System.getProperty("user.dir")+logo)));
        png.setWidth(90f);
        png.setHeight(90f);
        return png;
    }

    private Table createNestedTable(InvoiceDto invoice) {
        Table nestedTable = new Table(new float[]{1, 1}).useAllAvailableWidth();
        nestedTable.addCell(getHeaderTextCell("Invoice number: "));
        nestedTable.addCell(getHeaderTextCellValue(invoice.invoiceNumber()));
        nestedTable.addCell(getHeaderTextCell("Invoice date: "));
        nestedTable.addCell(getHeaderTextCellValue(invoice.completed().format(DATE_FORMAT)));
        nestedTable.addCell(getHeaderTextCell("Order number: "));
        nestedTable.addCell(getHeaderTextCellValue(invoice.orderNumber()));
        nestedTable.addCell(getHeaderTextCell("Order issued at: "));
        nestedTable.addCell(getHeaderTextCellValue(invoice.issuedAt().format(DATE_FORMAT)));
        return nestedTable;
    }

    private Cell getHeaderTextCellValue(String cellValue) {
        return new Cell().add(new Paragraph(cellValue)).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT);
    }

    private Cell getHeaderTextCell(String cellName) {
        return new Cell().add(new Paragraph(cellName)).setBold().setBorder(Border.NO_BORDER);
    }
}
