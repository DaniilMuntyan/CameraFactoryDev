package kpi.trspo.restapp.api.controllers.machine_controllers;


import kpi.trspo.restapp.api.dto.machine_dto.MachineDTO;
import kpi.trspo.restapp.services.models.machines.Calibrator;
import kpi.trspo.restapp.services.models.machines.Machine;
import kpi.trspo.restapp.services.repositories.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calibrator")
public final class CalibratorController {

    @Autowired
    private MachineRepository machineRepository;

    @PostMapping
    public ResponseEntity<Calibrator> create(@RequestBody MachineDTO machineDTO) {
        Calibrator newCalibrator = new Calibrator(machineDTO.getName());
        return ResponseEntity.ok(this.machineRepository.save(newCalibrator));
    }

    @GetMapping
    public ResponseEntity<List<Machine>> show() {
        return ResponseEntity.ok(this.machineRepository.findAll());
    }

}
