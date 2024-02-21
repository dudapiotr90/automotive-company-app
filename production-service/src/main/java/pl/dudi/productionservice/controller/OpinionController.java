package pl.dudi.productionservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dudi.productionservice.dto.OpinionRequestDto;
import pl.dudi.productionservice.service.OpinionService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/opinion")
public class OpinionController {

    private final OpinionService opinionService;

    @PostMapping
    public ResponseEntity<String> submitOpinion(
        @RequestBody OpinionRequestDto opinionRequest
    ) {
        String confirmationMessage = opinionService.submitOpinion(opinionRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(confirmationMessage);
    }
}
