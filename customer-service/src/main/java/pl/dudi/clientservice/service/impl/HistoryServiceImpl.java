package pl.dudi.clientservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import pl.dudi.basedomains.dto.CustomerDto;
import pl.dudi.basedomains.dto.PageRequestDto;
import pl.dudi.basedomains.utils.PageableService;
import pl.dudi.clientservice.dto.OrderDto;
import pl.dudi.clientservice.service.CustomerService;
import pl.dudi.clientservice.service.HistoryService;
import pl.dudi.clientservice.service.feignservice.OrderServiceAPIClient;

@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {

    public static final PageRequestDto DEFAULT_ORDER_HISTORY_REQUEST = new PageRequestDto(1, 10, "desc", "issuedDateTime");

    private final CustomerService customerService;
    private final PageableService pageableService;
    private final OrderServiceAPIClient orderServiceAPIClient;

//    @Override
//    public Page<OrderDto> showOrderHistory(OAuth2User user) {
//        return showOrderHistory(user, DEFAULT_PAGE_NUMBER,DEFAULT_PAGE_SIZE,DEFAULT_SORT_HOW,DEFAULT_SORT_BY);
//    }

    @Override
    public Page<OrderDto> showOrderHistory(
        OAuth2User user,
        Integer pageNumber,
        Integer pageSize,
        String sortHow,
        String... sortBy
    ) {
//        if (Objects.isNull(pageNumber) || pageNumber < 1) {
//            pageNumber = DEFAULT_PAGE_NUMBER;
//        }
//        if (Objects.isNull(pageSize) ||pageSize < 1) {
//            pageSize= DEFAULT_PAGE_NUMBER;
//        }
        PageRequestDto pageRequestDto = new PageRequestDto(pageNumber, pageSize, sortHow, sortBy);
        // TODO paste pageable to new module - order-service
        Pageable pageable = pageableService.preparePageable(DEFAULT_ORDER_HISTORY_REQUEST, pageNumber, pageSize, sortHow, sortBy);
        CustomerDto customerDto = customerService.extractUserData(user);
        return orderServiceAPIClient.getOrderHistory(customerDto.getCustomerCode(),pageRequestDto);
    }
}
