package pl.dudi.productionservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MachineDto {

    private String machineName;
    private String machineCode;
    private String loadCapacity;
    private BigDecimal length;
    private BigDecimal width;
    private BigDecimal maxPressureForce;
}
