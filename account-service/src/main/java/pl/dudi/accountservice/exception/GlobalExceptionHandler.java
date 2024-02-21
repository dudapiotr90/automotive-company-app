package pl.dudi.accountservice.exception;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.*;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import pl.dudi.accountservice.utility.UUIDGenerator;

import java.util.Map;

@Slf4j
@RestControllerAdvice(annotations = RestController.class)
@RequiredArgsConstructor
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private final UUIDGenerator uuidGenerator;
    private static final Map<Class<?>, HttpStatus> EXCEPTION_STATUS = Map.of(
        ConstraintViolationException.class, HttpStatus.BAD_REQUEST,
        DataIntegrityViolationException.class, HttpStatus.BAD_REQUEST,
        EntityNotFoundException.class, HttpStatus.NOT_FOUND
    );

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
        @NonNull Exception exception,
        @Nullable Object body,
        @NonNull HttpHeaders headers,
        @NonNull HttpStatusCode statusCode,
        @NonNull WebRequest request
    ) {
        final String errorId = uuidGenerator.generateUuid();
        log.error("Exception: ID={}, HttpStatus={}", errorId, statusCode, exception);
        return super.handleExceptionInternal(exception, ExceptionMessage.of(errorId), headers, statusCode, request);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handle(final Exception exception) {
        return doHandle(exception, getHttpStatusFromException(exception.getClass()));
    }

    private ResponseEntity<Object> doHandle(final Exception exception, final HttpStatus status) {
        final String errorId = uuidGenerator.generateUuid();
        log.error("Exception: ID={}, HttpStatus={}", errorId, status, exception);

        return ResponseEntity
            .status(status)
            .contentType(MediaType.APPLICATION_JSON)
            .body(ExceptionMessage.of(errorId));
    }


    private HttpStatus getHttpStatusFromException(final Class<?> exception) {
        return EXCEPTION_STATUS.getOrDefault(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
