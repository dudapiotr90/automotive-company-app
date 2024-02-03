package pl.dudi.productionservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductionTaskDto {

    private String productNumber;
    private BigDecimal piecesToMake;
    private String priority;
    private String status;
    private String taskDescription;
    private OffsetDateTime started;
    private OffsetDateTime deadline;
    private Long piecesAlreadyMade;
}
