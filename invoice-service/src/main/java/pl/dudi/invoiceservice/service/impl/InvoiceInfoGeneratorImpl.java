package pl.dudi.invoiceservice.service.impl;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.pdf.canvas.draw.SolidLine;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.dudi.invoiceservice.dto.CustomerDetailsDto;
import pl.dudi.invoiceservice.dto.InvoiceRequestDto;
import pl.dudi.invoiceservice.dto.SellerDetailsDto;
import pl.dudi.invoiceservice.service.InvoiceInfoGenerator;

import static pl.dudi.invoiceservice.service.impl.InvoiceTitleGeneratorImpl.PAGE_WIDTH;


@Slf4j
@Service
public class InvoiceInfoGeneratorImpl implements InvoiceInfoGenerator {

    @Override
    public Document prepareInfoSection(InvoiceRequestDto request, Document document) {
        float[] sections = {0.5f * PAGE_WIDTH, 40, 0.5f * PAGE_WIDTH};
        Table table = new Table(sections).setMargins(0, 5, 0, 5);
        table.addCell(addCompanyInformation(request.getSellerDetailsDto()).setBorder(Border.NO_BORDER));
        table.addCell(new Cell().setBorder(Border.NO_BORDER));
        table.addCell(addCustomerInformation(request.getCustomerDetailsDto()).setBorder(Border.NO_BORDER));
        document.add(table.setMarginBottom(25));

        return document;
    }
    private BlockElement<Cell> addCompanyInformation(SellerDetailsDto seller) {
        Cell cell = new Cell();
        Paragraph sellerHeader = new Paragraph("SELLER").setBold().setBackgroundColor(ColorConstants.LIGHT_GRAY).setFontSize(16f);
        cell.add(sellerHeader).setBorder(Border.NO_BORDER);
        cell.add(new LineSeparator(new SolidLine(1))).setMarginBottom(1);
        cell.add(new Paragraph("COMPANY NAME").setFontSize(12f));
        cell.add(new Paragraph(seller.printSeller()).setFontSize(9f));
        return cell;
    }

    private BlockElement<Cell> addCustomerInformation(CustomerDetailsDto customer) {
        Cell cell = new Cell();
        Paragraph sellerHeader = new Paragraph("CUSTOMER").setBold().setBackgroundColor(ColorConstants.LIGHT_GRAY).setFontSize(16f);
        cell.add(sellerHeader).setBorder(Border.NO_BORDER);
        cell.add(new LineSeparator(new SolidLine(1))).setMarginBottom(1);
        cell.add(new Paragraph(customer.printCustomer()).setFontSize(9f));
        return cell;
    }

}
