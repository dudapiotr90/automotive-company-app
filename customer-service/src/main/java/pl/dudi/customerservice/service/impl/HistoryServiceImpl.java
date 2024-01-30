package pl.dudi.customerservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import pl.dudi.basedomains.dto.CustomerDto;
import pl.dudi.basedomains.dto.OrderDto;
import pl.dudi.basedomains.dto.PageRequestDto;
import pl.dudi.customerservice.model.InvoiceDto;
import pl.dudi.customerservice.service.CustomerService;
import pl.dudi.customerservice.service.HistoryService;
import pl.dudi.customerservice.service.apiclient.InvoiceServiceAPIClient;
import pl.dudi.customerservice.service.apiclient.OrderServiceAPIClient;

@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {

    private final CustomerService customerService;
    private final OrderServiceAPIClient orderServiceAPIClient;
    private final InvoiceServiceAPIClient invoiceServiceAPIClient;


    @Override
    public Page<OrderDto> showOrderHistory(
        OAuth2User user,
        Integer pageNumber,
        Integer pageSize,
        String sortHow,
        String... sortBy
    ) {
        PageRequestDto pageRequestDto = new PageRequestDto(pageNumber, pageSize, sortHow, sortBy);
        CustomerDto customerDto = customerService.extractUserData(user);
        return orderServiceAPIClient.getOrderHistory(customerDto.getCustomerCode(),pageRequestDto);
    }

    @Override
    public Page<InvoiceDto> showInvoiceHistory(OAuth2User user, Integer pageNumber, Integer pageSize, String sortHow, String... sortBy) {
        PageRequestDto pageRequestDto = new PageRequestDto(pageNumber, pageSize, sortHow, sortBy);
        CustomerDto customerDto = customerService.extractUserData(user);

        return invoiceServiceAPIClient.getInvoiceHistory(customerDto.getCustomerCode(),pageRequestDto);
    }
}
