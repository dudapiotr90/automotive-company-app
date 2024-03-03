package pl.dudi.fileservice.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.dudi.fileservice.model.ErrorResponseMessage;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DocumentNotFoundException.class)
    public ResponseEntity<ErrorResponseMessage> handleDocumentNotFoundException(DocumentNotFoundException exception) {
        log.error("Exception: {}",exception.getMessage());
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .contentType(MediaType.APPLICATION_JSON)
            .body(new ErrorResponseMessage(HttpStatus.NOT_FOUND.value(), exception.getMessage()));
    }
}
