package pl.dudi.productionservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IssueTaskConfirmationResponse {

    private String machineName;
    private String machineCode;
    private OffsetDateTime productionStarts;
    private int issuerCode;

}
