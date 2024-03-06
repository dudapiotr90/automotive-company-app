package pl.dudi.managementservice.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record ProductionTaskDto(
    String productNumber,
    BigDecimal piecesToMake,
    String priority,
    String status,
    String taskDescription,
    OffsetDateTime started,
    OffsetDateTime deadline,
    Long piecesAlreadyMade
) {
}