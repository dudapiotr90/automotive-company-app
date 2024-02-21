package pl.dudi.managementservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.dudi.basedomains.dto.CustomerDto;
import pl.dudi.basedomains.dto.orders.OrderDto;
import pl.dudi.basedomains.dto.orders.OrderItemDto;
import pl.dudi.managementservice.dto.*;
import pl.dudi.managementservice.model.CommonSeller;
import pl.dudi.managementservice.model.Seller;
import pl.dudi.managementservice.service.InvoiceService;
import pl.dudi.managementservice.service.apiclients.AccountServiceApiClient;
import pl.dudi.managementservice.service.apiclients.OrderServiceApiClient;
import pl.dudi.managementservice.service.producer.EmailProducer;
import pl.dudi.managementservice.service.producer.InvoiceProducer;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Set;

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
//        OrderDto orderDetails = orderServiceApiClient.getOrder(orderNumber);
//        CustomerDto customerDetails = accountServiceApiClient.getCustomerDetails(orderDetails.getCustomerCode());



//        InvoiceRequestDto invoiceRequest = buildInvoiceRequest(orderDetails, customerDetails);

        InvoiceRequestDto invoiceRequest = generateRandomRequest();
        CustomerDto customerDetails =generateCustomerDto();

        InvoiceDto invoice = invoiceProducer.generateInvoice(invoiceRequest);
//        emailProducer.sendInvoiceToCustomer(invoice,customerDetails);
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
                    customer.getFullName(),
                    customer.getEmail(),
                    customer.getCustomerCode()
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

    private static InvoiceRequestDto generateRandomRequest() {
        return new InvoiceRequestDto(
            new CustomerDetailsDto(
                "Full Name",
                "dpiterd@gmail.com",
                1231313123
            ),
            new OrderDetailsDto(
                "someOrderNumber",
                "some customer comment to proceeding order",
                OffsetDateTime.now(),
                OffsetDateTime.now().plusHours(1),
                generateRandomItems()
            ),
            new SellerDetailsDto(
                "company name",
                "111 11 11 111",
                "+48 111 111 111",
                "someseller@mail.com"
            )
        );
    }

    private static CustomerDto generateCustomerDto() {
        return new CustomerDto(
            "Full Name",
            15455464,
            "somecustomer",
            "dpiterd@gmail.com"
        );
    }

    private static Set<OrderItemDto> generateRandomItems() {
        OrderItemDto item1 = new OrderItemDto(
            "some very long product description that wont fit to proper namefdgsdfgdgsdfgsgsdsgsdgsgsdg", "itemNumber1", BigDecimal.TEN,
            BigDecimal.valueOf(110),
            BigDecimal.valueOf(1100));
        OrderItemDto item2 = new OrderItemDto("item2", "itemNumber2", BigDecimal.ONE, BigDecimal.valueOf(200), BigDecimal.valueOf(200));
        OrderItemDto item3 = new OrderItemDto("item3", "itemNumber3", BigDecimal.TWO, BigDecimal.valueOf(300), BigDecimal.valueOf(600));
        return Set.of(item1, item2, item3);
    }
}
