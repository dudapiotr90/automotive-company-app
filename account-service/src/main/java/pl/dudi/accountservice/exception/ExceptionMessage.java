package pl.dudi.accountservice.exception;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(staticName = "of")
public class ExceptionMessage {

    String errorId;
}
