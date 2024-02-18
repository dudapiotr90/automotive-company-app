package pl.dudi.invoiceservice.service.impl;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.pdf.canvas.draw.SolidLine;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.LineSeparator;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import org.springframework.stereotype.Service;
import pl.dudi.invoiceservice.dto.InvoiceDto;
import pl.dudi.invoiceservice.service.InvoiceSummaryGenerator;

import java.math.BigDecimal;

@Service
public class InvoiceSummaryGeneratorImpl implements InvoiceSummaryGenerator {
    @Override
    public void prepareSummary(Document document, InvoiceDto invoice) {
        float[] nestedSplit = {55f, 45f};
        Table nestedTable = new Table(UnitValue.createPercentArray(nestedSplit))
            .setHorizontalAlignment(HorizontalAlignment.RIGHT).setMargins(5, 5, 30, 5);
        nestedTable
            .addCell(new Cell(0, 3).setBackgroundColor(ColorConstants.LIGHT_GRAY).setFontSize(12f)
                .add(new Paragraph("Summary").setBorder(Border.NO_BORDER).setBold()))
            .setTextAlignment(TextAlignment.CENTER)
            .addCell(new Cell()
                .add(new Paragraph("Total items:").setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT)))
            .addCell(new Cell()
                .add(new Paragraph(invoice.allItems().toString()).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT)))
            .addCell(new Cell()
                .add(new Paragraph("Invoice amount:").setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT)))
            .addCell(new Cell()
                .add(new Paragraph(invoice.totalAmount().toString()).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT)));
        document.add(nestedTable);
        document.add(new LineSeparator(new SolidLine(0.01f)).setMargins(10,5,10,5));
    }
}
