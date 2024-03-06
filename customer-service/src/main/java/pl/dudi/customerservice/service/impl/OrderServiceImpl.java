package pl.dudi.customerservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import pl.dudi.basedomains.dto.CustomerDto;
import pl.dudi.customerservice.dto.request.OrderRequestDto;
import pl.dudi.customerservice.dto.response.OrderDetails;
import pl.dudi.customerservice.service.CustomerService;
import pl.dudi.customerservice.service.OrderService;
import pl.dudi.customerservice.service.apiclient.OrderServiceAPIClient;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final CustomerService customerService;

    private final OrderServiceAPIClient apiClient;
    @Override
    public OrderDetails submitOrder(OAuth2User user, OrderRequestDto request) {
        CustomerDto customer = customerService.extractUserData(user);
        return apiClient.submitOrder(customer.customerCode(),request);
    }

    @Override
    public String cancelOrder(String orderNumber) {
        return apiClient.cancelOrder(orderNumber);
    }
}
