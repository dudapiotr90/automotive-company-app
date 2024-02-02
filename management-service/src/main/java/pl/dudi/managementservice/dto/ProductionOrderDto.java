package pl.dudi.managementservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductionOrderDto {

    private String productNumber;
    private BigDecimal piecesToMake;
    private String priority;
    private OffsetDateTime started;
    private OffsetDateTime deadline;
    private Long piecesAlreadyMade;
    private String status;
}
