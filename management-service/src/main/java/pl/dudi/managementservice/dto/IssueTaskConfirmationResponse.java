package pl.dudi.managementservice.dto;

import pl.dudi.managementservice.model.Manager;

import java.time.OffsetDateTime;

public record IssueTaskConfirmationResponse(
    String machineName,
    String machineCode,
    OffsetDateTime productionStarts,
    Manager issuer
) {
}
