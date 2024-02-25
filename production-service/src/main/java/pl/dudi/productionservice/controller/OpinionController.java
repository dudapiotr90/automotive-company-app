package pl.dudi.productionservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dudi.basedomains.dto.PageRequestDto;
import pl.dudi.productionservice.dto.OpinionRequestDto;
import pl.dudi.productionservice.dto.OpinionResponse;
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

    @GetMapping
    public ResponseEntity<Page<OpinionResponse>> getAllOpinions(
        @RequestParam(name = "productCode") String productCode,
        @RequestBody PageRequestDto pageRequestDto
    ) {
        Page<OpinionResponse> opinions = opinionService.getOpinions(productCode, pageRequestDto);
        return ResponseEntity
            .ok()
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .body(opinions);
    }

    @GetMapping("/{score}")
    public ResponseEntity<Page<OpinionResponse>> getAllOpinions(
        @PathVariable(name = "score") int score,
        @RequestParam(name = "productCode") String productCode,
        @RequestBody PageRequestDto pageRequestDto
    ) {
        Page<OpinionResponse> opinions = opinionService.getOpinionsByScore(productCode,score, pageRequestDto);
        return ResponseEntity
            .ok()
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .body(opinions);
    }


}
