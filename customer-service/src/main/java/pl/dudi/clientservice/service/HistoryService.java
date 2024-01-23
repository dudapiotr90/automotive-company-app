package pl.dudi.clientservice.service;

import org.springframework.data.domain.Page;
import org.springframework.security.oauth2.core.user.OAuth2User;
import pl.dudi.clientservice.dto.OrderDto;

public interface HistoryService {

    Page<OrderDto> showOrderHistory(OAuth2User user, Integer pageNumber,Integer pageSize, String sortHow, String... sortBy);
}
