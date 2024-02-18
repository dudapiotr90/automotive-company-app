package pl.dudi.invoiceservice.service.impl;

import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.FixedDashedBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.HorizontalAlignment;
import org.springframework.stereotype.Service;
import pl.dudi.invoiceservice.service.InvoiceSignGenerator;

@Service
public class InvoiceSignGeneratorImpl implements InvoiceSignGenerator {
    @Override
    public void addSign(Document document) {
        float[] split = {150};
        Table table = new Table(split).setMargins(30,5,0,5).setBorder(Border.NO_BORDER).setHorizontalAlignment(HorizontalAlignment.RIGHT);
        table.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph("Full name of Issuer")));
        table.addCell(new Cell().setBorder(Border.NO_BORDER).setBorderBottom(new FixedDashedBorder(0.5f))
            .setMarginBottom(5).add(new Paragraph("Some Issuer")));
        document.add(table);
    }
}
