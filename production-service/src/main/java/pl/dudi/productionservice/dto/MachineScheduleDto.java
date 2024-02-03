package pl.dudi.productionservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Queue;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MachineScheduleDto {

    MachineDto machine;
    List<ProductionTaskDto> machineSchedule;
}
