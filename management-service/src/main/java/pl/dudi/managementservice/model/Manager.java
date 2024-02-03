package pl.dudi.managementservice.model;

import lombok.Builder;
import lombok.Value;
import lombok.With;

@With
@Value
@Builder
public class Manager {

    int managerCode;
    String fullName;
    String email;

}
