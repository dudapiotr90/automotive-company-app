package pl.dudi.invoiceservice.model;

import com.itextpdf.layout.Document;

import java.nio.file.Path;

public record PdfFile(Document document, Path path) {
}
