package pl.dudi.customerservice.service;

import org.springframework.data.domain.Page;
import org.springframework.security.oauth2.core.user.OAuth2User;
import pl.dudi.basedomains.dto.orders.OrderDto;
import pl.dudi.customerservice.model.InvoiceDto;

public interface HistoryService {

    Page<OrderDto> showOrderHistory(OAuth2User user, Integer pageNumber, Integer pageSize, String sortHow, String... sortBy);

    Page<InvoiceDto> showInvoiceHistory(OAuth2User user, Integer pageNumber, Integer pageSize, String sortHow, String... sortBy);
}
