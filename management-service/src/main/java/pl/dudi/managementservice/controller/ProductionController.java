package pl.dudi.managementservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dudi.managementservice.dto.ProductionOrderDto;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/management")
public class ProductionController {

    @PostMapping("/production")
    public ResponseEntity<String> issueProduction(
        @RequestBody ProductionOrderDto items
        ) {
        return ResponseEntity.ok("Added to production");
    }
}
