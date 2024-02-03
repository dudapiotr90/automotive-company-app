package pl.dudi.managementservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Queue;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MachineScheduleDto {

    MachineDto machine;
    Queue<ProductionTaskDto> machineSchedule;
}
