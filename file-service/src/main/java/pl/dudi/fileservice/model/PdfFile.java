package pl.dudi.fileservice.model;

import lombok.NonNull;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

public record PdfFile(
    String originalFileName,
    String name,
    byte[] bytes
) implements MultipartFile {
    @Override
    @NonNull
    public String getName() {
        return this.name;
    }

    @Override
    public String getOriginalFilename() {
        return this.originalFileName;
    }

    @Override
    public String getContentType() {
        return "invoice";
    }

    @Override
    public boolean isEmpty() {
        return bytes==null || bytes.length==0;
    }

    @Override
    public long getSize() {
        return bytes.length;
    }

    @Override
    public byte @NonNull [] getBytes() throws IOException {
        return bytes;
    }

    @Override
    @NonNull
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(bytes);
    }

    @Override
    public void transferTo(@NonNull File dest) throws IOException, IllegalStateException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(dest)){
            fileOutputStream.write(bytes);
        }
    }
}
