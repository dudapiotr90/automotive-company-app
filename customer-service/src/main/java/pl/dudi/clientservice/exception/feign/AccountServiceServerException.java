package pl.dudi.clientservice.exception.feign;


import feign.Response;
import lombok.Getter;

@Getter
public class AccountServiceServerException extends RuntimeException{

    private final String requestUrl;
    private final Response.Body responseBody;

    public AccountServiceServerException(String requestUrl, Response.Body responseBody) {
        super(responseBody.toString());
        this.requestUrl = requestUrl;
        this.responseBody = responseBody;
    }


}
