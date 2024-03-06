package pl.dudi.invoiceservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.dudi.basedomains.dto.PageRequestDto;
import pl.dudi.basedomains.utils.PageableService;
import pl.dudi.invoiceservice.dto.request.InvoiceRequestDto;
import pl.dudi.invoiceservice.dto.response.InvoiceDetails;
import pl.dudi.invoiceservice.infrastructure.dao.InvoiceDao;
import pl.dudi.invoiceservice.infrastructure.entity.InvoiceEntity;
import pl.dudi.invoiceservice.mapper.InvoiceMapper;
import pl.dudi.invoiceservice.model.Invoice;
import pl.dudi.invoiceservice.service.InvoiceDetailsService;
import pl.dudi.invoiceservice.service.InvoiceService;

@Slf4j
@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceDao invoiceDao;
    private final InvoiceDetailsService invoiceDetailsService;
    private final InvoiceMapper invoiceMapper;
    private final PageableService pageableService;

    @Override
    public Invoice issueInvoice(InvoiceRequestDto request) {
        InvoiceEntity lastInvoice = invoiceDao.findLastInvoice(request.getCustomerDetailsDto().getEmail());
        Invoice invoice = invoiceDetailsService.prepareInvoiceDetails(request,lastInvoice);
        invoiceDao.saveInvoice(invoiceMapper.mapToEntity(invoice));

        return invoice;
    }

    @Override
    public Page<InvoiceDetails> findInvoices(int customerCode, PageRequestDto pageRequestDto) {
        Pageable pageable = pageableService.preparePageable(DEFAULT_INVOICE_HISTORY_REQUEST, pageRequestDto);
        Page<Invoice> invoices = invoiceDao.findInvoices(customerCode, pageable);
        return invoices.map(invoice -> new InvoiceDetails(
            invoice.issuedAt(),
            invoice.completed(),
            invoice.orderNumber(),
            invoice.invoiceNumber(),
            invoice.allItems(),
            invoice.totalAmount()
        ));
    }
}
