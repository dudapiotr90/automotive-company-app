package pl.dudi.productionservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dudi.productionservice.dto.IssueTaskConfirmationResponse;
import pl.dudi.productionservice.dto.MachineScheduleDto;
import pl.dudi.productionservice.dto.ProductionTaskDto;

@RequestMapping("/production")
public class ProductionController {

    @GetMapping("/schedule")
    public ResponseEntity<MachineScheduleDto> getMachineSchedule(
        @RequestParam("machineCode") String machineCode
    ) {
        return null;
    }

    @PostMapping("/tasks")
    public ResponseEntity<IssueTaskConfirmationResponse> addTask(
        @RequestBody ProductionTaskDto task
    ) {
        return null;
    }
}
