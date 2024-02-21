package pl.dudi.emailservice.model;

import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RequiredArgsConstructor
public class PdfMultipartFile implements MultipartFile {

    private final String originalFileName;
    private final String name;

    private final byte[] bytes;
    @Override
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
    public byte[] getBytes() throws IOException {
        return bytes;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(bytes);
    }

    @Override
    public void transferTo(File dest) throws IOException, IllegalStateException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(dest)){
            fileOutputStream.write(bytes);
        }
    }
}
