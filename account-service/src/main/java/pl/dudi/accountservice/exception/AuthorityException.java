package pl.dudi.accountservice.exception;

public class AuthorityException extends RuntimeException{
    public AuthorityException(String message) {
        super(message);
    }
}
