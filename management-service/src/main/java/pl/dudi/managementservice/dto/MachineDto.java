package pl.dudi.managementservice.dto;

import java.math.BigDecimal;

public record MachineDto(
    String machineName,
    String machineCode,
    String loadCapacity,
    BigDecimal length,
    BigDecimal width,
    BigDecimal maxPressureForce
) {

}
