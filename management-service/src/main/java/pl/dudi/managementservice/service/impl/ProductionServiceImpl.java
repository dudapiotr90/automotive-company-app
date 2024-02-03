package pl.dudi.managementservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.dudi.managementservice.dto.IssueTaskConfirmationResponse;
import pl.dudi.managementservice.dto.MachineScheduleDto;
import pl.dudi.managementservice.dto.ProductionTaskDto;
import pl.dudi.managementservice.service.ProductionService;
import pl.dudi.managementservice.service.apiclients.ProductionServiceApiClient;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductionServiceImpl implements ProductionService {

    private final ProductionServiceApiClient productionServiceApiClient;

    @Override
    public MachineScheduleDto getMachineSchedule(String machineCode) {
        return productionServiceApiClient.getMachineSchedule(machineCode);
    }

    @Override
    public IssueTaskConfirmationResponse issueTask(ProductionTaskDto task) {
        return productionServiceApiClient.issueTask(task);
    }
}
