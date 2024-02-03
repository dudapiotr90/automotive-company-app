package pl.dudi.managementservice.service.apiclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import pl.dudi.managementservice.configuration.feign.FeignClientConfig;
import pl.dudi.managementservice.dto.IssueTaskConfirmationResponse;
import pl.dudi.managementservice.dto.MachineScheduleDto;
import pl.dudi.managementservice.dto.ProductionTaskDto;

@FeignClient(name = "production-service", configuration = FeignClientConfig.class)
public interface ProductionServiceApiClient {


    @GetMapping("/production/machine")
    MachineScheduleDto getMachineSchedule(@RequestParam("machineCode") String machineCode);

    @PostMapping("/production/tasks")
    IssueTaskConfirmationResponse issueTask(@RequestBody ProductionTaskDto task);
}
