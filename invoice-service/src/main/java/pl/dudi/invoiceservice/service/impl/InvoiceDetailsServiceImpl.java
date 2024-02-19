package pl.dudi.invoiceservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.dudi.basedomains.dto.orders.OrderItemDto;
import pl.dudi.invoiceservice.dto.CustomerDetailsDto;
import pl.dudi.invoiceservice.model.Invoice;
import pl.dudi.invoiceservice.dto.InvoiceRequestDto;
import pl.dudi.invoiceservice.dto.OrderDetailsDto;
import pl.dudi.invoiceservice.infrastructure.dao.InvoiceDao;
import pl.dudi.invoiceservice.infrastructure.entity.InvoiceEntity;
import pl.dudi.invoiceservice.model.Customer;
import pl.dudi.invoiceservice.service.InvoiceDetailsService;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class InvoiceDetailsServiceImpl implements InvoiceDetailsService {

    public static final String INV_TEMPLATE = "INV_%s_%s";


    private final InvoiceDao invoiceDao;
    @Override
    public Invoice prepareInvoiceDetails(InvoiceRequestDto request) {
        InvoiceEntity lastInvoice = invoiceDao.findLastInvoice(request.getCustomerDetailsDto().getEmail());

        return new Invoice(
            request.getSellerDetailsDto().getIssuer(),
            getCustomer(request.getCustomerDetailsDto()),
            request.getOrderDetailsDto().getIssuedDateTime(),
            OffsetDateTime.now(),
            request.getOrderDetailsDto().getOrderNumber(),
            generateInvoiceNumber(lastInvoice,request.getCustomerDetailsDto()),
            getAllItems(request.getOrderDetailsDto()),
            getTotalAmount(request.getOrderDetailsDto())
        );
    }

    private Customer getCustomer(CustomerDetailsDto customerDetailsDto) {
        return new Customer(customerDetailsDto.getFullName(), customerDetailsDto.getEmail());
    }

    private String generateInvoiceNumber(InvoiceEntity lastInvoice, CustomerDetailsDto customerDetailsDto) {
        return INV_TEMPLATE.formatted(customerDetailsDto.getCustomerCode(),lastInvoice.getInvoiceId()+1);
    }

    private BigDecimal getAllItems(OrderDetailsDto orderDetailsDto) {
        return orderDetailsDto.getItems().stream()
            .map(OrderItemDto::getQuantity)
            .reduce(BigDecimal.ZERO,BigDecimal::add);
    }

    private BigDecimal getTotalAmount(OrderDetailsDto orderDetailsDto) {
        return orderDetailsDto.getItems().stream()
            .map(OrderItemDto::getTotalCost)
            .reduce(BigDecimal.ZERO,BigDecimal::add);
    }
}
