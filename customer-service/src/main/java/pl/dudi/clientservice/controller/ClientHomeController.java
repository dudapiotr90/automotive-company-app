package pl.dudi.clientservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dudi.clientservice.service.ClientService;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientHomeController {

    private final ClientService clientService;

    @GetMapping
    public ResponseEntity<String> clientDetails(
        @AuthenticationPrincipal OAuth2User user
    ) {
        clientService.createClientAccount(user);
        return ResponseEntity.ok("You've been added to our database");
    }

}
