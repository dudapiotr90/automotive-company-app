package pl.dudi.invoiceservice.service.impl;

import com.itextpdf.kernel.pdf.canvas.draw.SolidLine;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.LineSeparator;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import org.springframework.stereotype.Service;
import pl.dudi.invoiceservice.dto.OrderDetailsDto;
import pl.dudi.invoiceservice.service.InvoiceCommentsGenerator;

@Service
public class InvoiceCommentsGeneratorImpl implements InvoiceCommentsGenerator {
    @Override
    public void prepareComments(Document document, OrderDetailsDto orderDetailsDto) {
        Table table = new Table(1).setMargins(0,5,0,5);
        table.addHeaderCell(new Cell().add(new Paragraph("Comments:")).setBold().setBorder(Border.NO_BORDER));
        table.addCell(new Cell().add(new Paragraph(orderDetailsDto.getCustomerComment())).setBorder(Border.NO_BORDER));
        document.add(table);
        document.add(new LineSeparator(new SolidLine(0.01f)).setMargins(10,5,10,5));
    }
}
