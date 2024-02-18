package pl.dudi.invoiceservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.dudi.invoiceservice.dto.InvoiceDto;
import pl.dudi.invoiceservice.dto.InvoiceRequestDto;
import pl.dudi.invoiceservice.infrastructure.dao.InvoiceDao;
import pl.dudi.invoiceservice.infrastructure.entity.InvoiceEntity;
import pl.dudi.invoiceservice.service.InvoiceDetailsService;

@Slf4j
@Service
@RequiredArgsConstructor
public class InvoiceDetailsServiceImpl implements InvoiceDetailsService {


    private final InvoiceDao invoiceDao;
    @Override
    public InvoiceDto prepareInvoiceDetails(InvoiceRequestDto request) {
        InvoiceEntity lastInvoice = invoiceDao.findLastInvoice(request.getCustomerDetailsDto().getEmail());

        return null;
    }
}
