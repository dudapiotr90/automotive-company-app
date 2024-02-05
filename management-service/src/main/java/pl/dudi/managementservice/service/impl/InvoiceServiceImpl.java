package pl.dudi.managementservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.dudi.managementservice.dto.InvoiceDto;
import pl.dudi.managementservice.service.InvoiceService;
import pl.dudi.managementservice.service.apiclients.AccountServiceApiClient;
import pl.dudi.managementservice.service.apiclients.OrderServiceApiClient;
import pl.dudi.managementservice.service.producer.EmailProducer;
import pl.dudi.managementservice.service.producer.InvoiceProducer;

@Slf4j
@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final AccountServiceApiClient accountServiceApiClient;
    private final OrderServiceApiClient orderServiceApiClient;
    private final InvoiceProducer invoiceProducer;
    private final EmailProducer emailProducer;

    @Override
    public InvoiceDto issueInvoice(String orderNumber) {
        // TODO

        InvoiceDto invoiceDto = invoiceProducer.generateInvoice(orderNumber);
        emailProducer.sendInvoiceToCustomer(invoiceDto);
        return invoiceDto;
    }
}
