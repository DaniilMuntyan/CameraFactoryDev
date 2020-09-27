package kpi.trspo.restapp.api.controllers.machine_controllers;


import kpi.trspo.restapp.api.dto.machine_dto.MachineDTO;
import kpi.trspo.restapp.entities.machines.Calibrator;
import kpi.trspo.restapp.repositories.machine_repo.CalibratorRepository;
import kpi.trspo.restapp.services.models.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calibrators")
public final class CalibratorController {

    private final MachineService machineService;

    @Autowired
    public CalibratorController(MachineService machineService) {
        this.machineService = machineService;
    }

    @PostMapping
    public ResponseEntity<Calibrator> create(@RequestBody MachineDTO machineDTO) {
        Calibrator newCalibrator = new Calibrator(machineDTO.getName());
        return ResponseEntity.ok(this.machineService.save(newCalibrator));
    }

    @GetMapping
    public ResponseEntity<List<Calibrator>> show() {
        return ResponseEntity.ok(this.machineService.findAllCalibrators());
    }

}
