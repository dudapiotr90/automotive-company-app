package pl.dudi.orderservice.utility;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@NoArgsConstructor
public class UUIDGenerator {

    public String generateUuid() {
        return UUID.randomUUID().toString();
    }

}