package pl.dudi.managementservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.dudi.basedomains.dto.CustomerDto;
import pl.dudi.basedomains.dto.orders.OrderDto;
import pl.dudi.managementservice.dto.*;
import pl.dudi.managementservice.model.CommonSeller;
import pl.dudi.managementservice.model.Seller;
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
        OrderDto orderDetails = orderServiceApiClient.getOrder(orderNumber);
        CustomerDto customerDetails = accountServiceApiClient.getCustomerDetails(orderDetails.getCustomerCode());

        InvoiceRequestDto invoiceRequest = buildInvoiceRequest(orderDetails, customerDetails);

        InvoiceDto invoice = invoiceProducer.generateInvoice(invoiceRequest);
        emailProducer.sendInvoiceToCustomer(invoice,customerDetails);
        return invoice;
    }


    private InvoiceRequestDto buildInvoiceRequest(OrderDto orderDetails, CustomerDto customerDetails) {
        return buildInvoiceRequest(orderDetails, customerDetails, CommonSeller.defaultSeller());
    }

    private InvoiceRequestDto buildInvoiceRequest(OrderDto order, CustomerDto customer, Seller seller) {
        return InvoiceRequestDto.builder()
            .orderDetailsDto(new OrderDetailsDto(
                    order.getOrderNumber(),
                    order.getComment(),
                    order.getIssuedDateTime(),
                    order.getRealizedDateTime(),
                    order.getItems()
                )
            )
            .customerDetailsDto(new CustomerDetailsDto(
                    customer.fullName(),
                    customer.email(),
                    customer.customerCode()
                )
            )
            .sellerDetailsDto(new SellerDetailsDto(
                    seller.getCompanyName(),
                    seller.getNip(),
                    seller.getEmail(),
                    seller.getPhoneNumber()
                )
            )
            .build();
    }

}
