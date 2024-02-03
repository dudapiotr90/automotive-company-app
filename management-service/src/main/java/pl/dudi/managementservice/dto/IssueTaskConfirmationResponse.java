package pl.dudi.managementservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.dudi.managementservice.model.Manager;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IssueTaskConfirmationResponse {

    private String machineName;
    private String machineCode;
    private OffsetDateTime productionStarts;
    private Manager issuer;

}
