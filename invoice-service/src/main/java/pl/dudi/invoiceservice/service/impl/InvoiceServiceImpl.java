package pl.dudi.invoiceservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.dudi.invoiceservice.dto.InvoiceDto;
import pl.dudi.invoiceservice.dto.InvoiceRequestDto;
import pl.dudi.invoiceservice.infrastructure.dao.InvoiceDao;
import pl.dudi.invoiceservice.infrastructure.entity.InvoiceEntity;
import pl.dudi.invoiceservice.mapper.InvoiceMapper;
import pl.dudi.invoiceservice.model.Invoice;
import pl.dudi.invoiceservice.model.PdfFile;
import pl.dudi.invoiceservice.service.InvoiceDetailsService;
import pl.dudi.invoiceservice.service.InvoiceGenerator;
import pl.dudi.invoiceservice.service.InvoiceService;

import java.io.IOException;
import java.nio.file.Files;

@Slf4j
@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {



    private final InvoiceDao invoiceDao;
    private final InvoiceDetailsService invoiceDetailsService;
    private final InvoiceMapper invoiceMapper;

    @Override
    public Invoice issueInvoice(InvoiceRequestDto request) {
        InvoiceEntity lastInvoice = invoiceDao.findLastInvoice(request.getCustomerDetailsDto().getEmail());
        Invoice invoice = invoiceDetailsService.prepareInvoiceDetails(request,lastInvoice);
        invoiceDao.saveInvoice(invoiceMapper.mapToEntity(invoice));

        return invoice;
    }


}
