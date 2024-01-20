package pl.dudi.accountservice.model;


import lombok.Builder;
import lombok.Value;
import lombok.With;

@With
@Value
@Builder
public class Customer {

    String fullName;
    int customerCode;
    String email;
    Account account;

}
