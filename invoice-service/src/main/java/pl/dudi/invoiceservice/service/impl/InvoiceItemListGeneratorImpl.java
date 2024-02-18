package pl.dudi.invoiceservice.service.impl;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.Property;
import com.itextpdf.layout.properties.UnitValue;
import com.itextpdf.layout.splitting.DefaultSplitCharacters;
import org.springframework.stereotype.Service;
import pl.dudi.basedomains.dto.orders.OrderItemDto;
import pl.dudi.invoiceservice.dto.OrderDetailsDto;
import pl.dudi.invoiceservice.service.InvoiceItemListGenerator;

import java.util.Set;

@Service
public class InvoiceItemListGeneratorImpl implements InvoiceItemListGenerator {

    private static final float[] PRODUCT_LIST_TABLE_COLUMNS = {3, 45, 25, 5, 9, 13};

    @Override
    public Document prepareProductList(Document document, OrderDetailsDto orderDetailsDto) {
        Table table = new Table(UnitValue.createPercentArray(PRODUCT_LIST_TABLE_COLUMNS)).setFontSize(10f).setMargins(5, 5, 5, 5);
        System.out.println(table.getColumnWidth(0));
        System.out.println(table.getColumnWidth(1));
        System.out.println(table.getColumnWidth(2));
        System.out.println(table.getColumnWidth(3));
        table
            .addHeaderCell(new Cell().setBackgroundColor(ColorConstants.LIGHT_GRAY).add(new Paragraph("Nr").setBold().setFontSize(10f)))
            .addHeaderCell(new Cell().setBackgroundColor(ColorConstants.LIGHT_GRAY).add(new Paragraph("Description").setBold().setFontSize(10f)))
            .addHeaderCell(new Cell().setBackgroundColor(ColorConstants.LIGHT_GRAY).add(new Paragraph("Product id").setBold().setFontSize(10f)))
            .addHeaderCell(new Cell().setBackgroundColor(ColorConstants.LIGHT_GRAY).add(new Paragraph("Qty").setBold().setFontSize(10f)))
            .addHeaderCell(new Cell().setBackgroundColor(ColorConstants.LIGHT_GRAY).add(new Paragraph("Cost/Item").setBold().setFontSize(10f)))
            .addHeaderCell(new Cell().setBackgroundColor(ColorConstants.LIGHT_GRAY).add(new Paragraph("Total cost").setBold().setFontSize(10f)));
        fillInItems(table, orderDetailsDto.getItems());

        document.add(table);
        return document;
    }
    private void fillInItems(Table table, Set<OrderItemDto> items) {
        int counter = 1;
        Cell cell = new Cell();
        cell.setProperty(Property.SPLIT_CHARACTERS, new DefaultSplitCharacters());
        for (OrderItemDto item : items) {
            table
                .addCell(String.valueOf(counter))
                .addCell(new Cell().add(new Paragraph(item.getProductName())))
                .addCell(item.getProductNumber())
                .addCell(String.valueOf(item.getQuantity()))
                .addCell(String.valueOf(item.getPrice()))
                .addCell(String.valueOf(item.getTotalCost()));
            counter++;
        }
    }
}
