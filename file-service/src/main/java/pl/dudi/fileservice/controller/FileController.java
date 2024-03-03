package pl.dudi.fileservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.dudi.fileservice.service.FileService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/files")
public class FileController {

    private final FileService fileService;

    @GetMapping(value = "{invoiceNumber}")
    public ResponseEntity<MultipartFile> fetchInvoice(
        @PathVariable(name = "invoiceNumber") String invoiceNumber
    ) {
        MultipartFile invoice = fileService.fetchInvoice(invoiceNumber);
        return ResponseEntity
            .ok()
            .header(HttpHeaders.CONTENT_TYPE, MediaType.MULTIPART_FORM_DATA_VALUE)
            .body(invoice);
    }

    @DeleteMapping(value = "{invoiceNumber}")
    public ResponseEntity<String> deleteInvoice(
        @PathVariable(name = "invoiceNumber") String invoiceNumber
    ) {
        String responseMessage = fileService.deleteInvoice(invoiceNumber);
        return ResponseEntity.ok(responseMessage);
    }
}
