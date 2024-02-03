package pl.dudi.managementservice.model;

import lombok.Builder;
import lombok.Value;
import lombok.With;
import pl.dudi.managementservice.dto.ProductionTaskDto;

import java.util.Queue;

@With
@Value
@Builder
public class MachineSchedule {

    String machineName;
    String machineCode;
    Queue<ProductionTaskDto> machineSchedule;

}
