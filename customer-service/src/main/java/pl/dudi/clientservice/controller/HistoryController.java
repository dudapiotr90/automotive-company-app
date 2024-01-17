package pl.dudi.clientservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;
import pl.dudi.clientservice.dto.OrderDto;
import pl.dudi.clientservice.dto.PageRequestDto;
import pl.dudi.clientservice.service.HistoryService;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client/history")
public class HistoryController {

    private final HistoryService historyService;
//
//
//    @GetMapping("/order")
//    public ResponseEntity<Page<OrderDto>> showOrderHistory(
//        @RequestBody PageRequestDto pageRequest,
//        @AuthenticationPrincipal OAuth2User user
//        ) {
//        user.getAttribute("email");
//        user.getAttribute("login");
//    }
//
//    @GetMapping("/invoice")
//    public ResponseEntity<Page<OrderDto>> showInvoiceHistory() {
//
//    }


}
