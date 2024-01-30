package pl.dudi.basedomains.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class FeignExceptionMessage {

    private String timestamp;
    private int status;
    private String error;
    private String message;
    private String path;

}
