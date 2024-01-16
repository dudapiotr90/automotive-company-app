package pl.dudi.clientservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import pl.dudi.clientservice.service.HistoryService;

@RestController
@RequiredArgsConstructor
public class HistoryController {

    private final HistoryService historyService;
}
