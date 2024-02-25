package pl.dudi.fileservice.infrastructure.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestClient;

import java.nio.charset.Charset;

@Configuration
public class RestClientConfig {


    private static final String BEARER = "Bearer ";
    @Value("${host.apiKey}")
    private String apiKey;
    @Bean
    public RestClient restClient(ObjectMapper objectMapper) {
        return RestClient.builder()
            .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
            .defaultHeader(HttpHeaders.AUTHORIZATION,BEARER+apiKey)
            .messageConverters(httpMessageConverters -> {
                httpMessageConverters.add(new MappingJackson2HttpMessageConverter(objectMapper));
                httpMessageConverters.add(new StringHttpMessageConverter(Charset.defaultCharset()));
            })
            .build();
    }
}
