package pl.dudi.invoiceservice.service.impl;

import com.itextpdf.layout.Document;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.dudi.invoiceservice.dto.InvoiceDto;
import pl.dudi.invoiceservice.dto.InvoiceRequestDto;
import pl.dudi.invoiceservice.service.InvoiceDetailsService;
import pl.dudi.invoiceservice.service.InvoiceGenerator;
import pl.dudi.invoiceservice.service.InvoiceService;

@Slf4j
@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {


    private final InvoiceGenerator invoiceGenerator;
    private final InvoiceDetailsService invoiceDetailsService;

    @Override
    public InvoiceDto processInvoice(InvoiceRequestDto request)  {
        InvoiceDto invoiceDto = invoiceDetailsService.prepareInvoiceDetails(request);
        Document document = invoiceGenerator.generateInvoice(request,invoiceDto);




        return null;
    }




}
