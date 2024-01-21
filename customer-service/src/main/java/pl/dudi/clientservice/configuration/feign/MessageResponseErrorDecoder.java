package pl.dudi.clientservice.configuration.feign;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import pl.dudi.clientservice.exception.feign.AccountServiceClientException;
import pl.dudi.clientservice.exception.feign.AccountServiceServerException;
import pl.dudi.clientservice.exception.feign.FeignExceptionMessage;

import java.io.IOException;
import java.io.InputStream;

@Component
@RequiredArgsConstructor
public class MessageResponseErrorDecoder implements ErrorDecoder {

    private final ObjectMapper objectMapper;

    @Override
    public Exception decode(String methodKey, Response response) {
        String requestUrl = response.request().url();
        HttpStatus responseStatus = HttpStatus.valueOf(response.status());
        Response.Body responseBody = response.body();

        FeignExceptionMessage message = null;
        try (InputStream bodyAsIS = responseBody.asInputStream()) {
            message = objectMapper.readValue(bodyAsIS, FeignExceptionMessage.class);
        } catch (IOException e) {
            return new Exception(e.getMessage());
        }

        if (responseStatus.is5xxServerError()) {
            return new AccountServiceServerException(requestUrl,responseBody);
        } else if (responseStatus.is4xxClientError()) {
            return new AccountServiceClientException(requestUrl, responseBody);
        } else {
            return new Default().decode(methodKey,response);
        }
    }
}
