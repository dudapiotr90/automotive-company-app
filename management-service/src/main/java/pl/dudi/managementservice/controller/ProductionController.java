package pl.dudi.managementservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dudi.managementservice.dto.IssueTaskConfirmationResponse;
import pl.dudi.managementservice.dto.MachineScheduleDto;
import pl.dudi.managementservice.dto.ProductionTaskDto;
import pl.dudi.managementservice.model.MachineSchedule;
import pl.dudi.managementservice.service.ProductionService;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/management")
public class ProductionController {

    private ProductionService productionService;

    @PostMapping("/production")
    public ResponseEntity<IssueTaskConfirmationResponse> issueProduction(
        @RequestBody ProductionTaskDto task
        ) {
        IssueTaskConfirmationResponse confirmation = productionService.issueTask(task);
        return ResponseEntity.ok(confirmation);
    }

    @GetMapping("/production")
    public ResponseEntity<MachineScheduleDto> getMachineSchedule(
        @RequestParam("machineCode") String machineCode
    ) {
        MachineScheduleDto schedule = productionService.getMachineSchedule(machineCode);
        return ResponseEntity.ok(schedule);
    }


}
