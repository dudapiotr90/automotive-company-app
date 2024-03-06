package pl.dudi.managementservice.dto;

import java.util.Queue;

public record MachineScheduleDto(
    MachineDto machine,
    Queue<ProductionTaskDto> machineSchedule
) {

}
