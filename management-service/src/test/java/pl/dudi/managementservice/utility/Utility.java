package pl.dudi.managementservice.utility;

import pl.dudi.basedomains.dto.CustomerDto;
import pl.dudi.basedomains.dto.orders.OrderItemDto;
import pl.dudi.managementservice.dto.CustomerDetailsDto;
import pl.dudi.managementservice.dto.InvoiceRequestDto;
import pl.dudi.managementservice.dto.OrderDetailsDto;
import pl.dudi.managementservice.dto.SellerDetailsDto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Set;

public class Utility {
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
