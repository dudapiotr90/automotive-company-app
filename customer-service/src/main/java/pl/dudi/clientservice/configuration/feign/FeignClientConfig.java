package pl.dudi.clientservice.configuration.feign;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {

    @Bean
    public ErrorDecoder errorDecoder(ObjectMapper objectMapper) {
        return new MessageResponseErrorDecoder(objectMapper);
    }
}
