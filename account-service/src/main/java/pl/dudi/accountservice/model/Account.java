package pl.dudi.accountservice.model;

import lombok.Builder;
import lombok.Value;
import lombok.With;

import java.time.OffsetDateTime;

@With
@Value
@Builder
public class Account {

    String email;
    String login;
    String password;
    String role;
    OffsetDateTime creationDate;
}
