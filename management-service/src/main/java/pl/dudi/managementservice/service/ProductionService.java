package pl.dudi.managementservice.service;

import pl.dudi.managementservice.dto.IssueTaskConfirmationResponse;
import pl.dudi.managementservice.dto.MachineScheduleDto;
import pl.dudi.managementservice.dto.ProductionTaskDto;

public interface ProductionService {
    MachineScheduleDto getMachineSchedule(String machineCode);

    IssueTaskConfirmationResponse issueTask(ProductionTaskDto task);
}
