package pl.dudi.basedomains.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UuidGenerator {

    public String generateUuid() {
        return UUID.randomUUID().toString();
    }

}