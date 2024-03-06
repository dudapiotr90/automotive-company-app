package pl.dudi.invoiceservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.dudi.basedomains.dto.orders.OrderItemDto;
import pl.dudi.invoiceservice.dto.request.CustomerDetailsDto;
import pl.dudi.invoiceservice.dto.request.InvoiceRequestDto;
import pl.dudi.invoiceservice.dto.request.OrderDetailsDto;
import pl.dudi.invoiceservice.infrastructure.entity.InvoiceEntity;
import pl.dudi.invoiceservice.model.Customer;
import pl.dudi.invoiceservice.model.Invoice;
import pl.dudi.invoiceservice.service.InvoiceDetailsService;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class InvoiceDetailsServiceImpl implements InvoiceDetailsService {

    public static final String INV_TEMPLATE = "INV_%s_%s";
    @Override
    public Invoice prepareInvoiceDetails(InvoiceRequestDto request, InvoiceEntity invoice) {
        return new Invoice(
            getCustomer(request.getCustomerDetailsDto()),
            request.getOrderDetailsDto().getIssuedDateTime(),
            OffsetDateTime.now(),
            request.getOrderDetailsDto().getOrderNumber(),
            generateInvoiceNumber(invoice,request.getCustomerDetailsDto()),
            getAllItems(request.getOrderDetailsDto()),
            getTotalAmount(request.getOrderDetailsDto()),
            request.getSellerDetailsDto().getIssuer()
        );
    }

    private Customer getCustomer(CustomerDetailsDto customerDetailsDto) {
        return new Customer(customerDetailsDto.getFullName(), customerDetailsDto.getEmail());
    }

    private String generateInvoiceNumber(InvoiceEntity lastInvoice, CustomerDetailsDto customerDetailsDto) {
        String[] invoiceNumberComponents = lastInvoice.getInvoiceNumber().split("_");
        int invoiceForCustomer = Integer.parseInt(invoiceNumberComponents[2]);
        return INV_TEMPLATE.formatted(customerDetailsDto.getCustomerCode(),invoiceForCustomer+1);
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
