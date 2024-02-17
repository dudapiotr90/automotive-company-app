package pl.dudi.invoiceservice.service.impl;

import com.itextpdf.layout.Document;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.dudi.invoiceservice.dto.InvoiceRequestDto;
import pl.dudi.invoiceservice.service.InvoiceInfoGenerator;

@Slf4j
@Service
public class InvoiceInfoGeneratorImpl implements InvoiceInfoGenerator {
    @Override
    public Document prepareInfoSection(InvoiceRequestDto request, Document document) {

        return document;
    }
}
