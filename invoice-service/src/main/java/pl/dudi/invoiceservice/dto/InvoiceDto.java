package pl.dudi.invoiceservice.dto;

import org.springframework.web.multipart.MultipartFile;

public record InvoiceDto(byte[] file) {
}
