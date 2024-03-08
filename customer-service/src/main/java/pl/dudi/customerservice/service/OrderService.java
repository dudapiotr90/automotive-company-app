package pl.dudi.customerservice.service;

import org.springframework.security.oauth2.core.user.OAuth2User;
import pl.dudi.customerservice.dto.request.OrderRequestDto;
import pl.dudi.customerservice.dto.response.OrderDetails;

public interface OrderService {
    OrderDetails submitOrder(OAuth2User user, OrderRequestDto request);

    String cancelOrder(String orderNumber);

    OrderDetails modifyOrder(OAuth2User user, String orderNumber, OrderRequestDto request);
}
