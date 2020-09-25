package kpi.trspo.restapp.api.controllers.machine_controllers;

import kpi.trspo.restapp.api.dto.machine_dto.MachineDTO;
import kpi.trspo.restapp.services.models.machines.Machine;
import kpi.trspo.restapp.services.models.machines.Packer;
import kpi.trspo.restapp.services.models.machines.Tester;
import kpi.trspo.restapp.services.repositories.MachineRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tester")
public class TesterController {

    @Autowired
    private MachineRepository machineRepository;

    @PostMapping
    public ResponseEntity<Tester> create(@RequestBody MachineDTO machineDTO) {
        Tester newTester = new Tester(machineDTO.getName());
        return ResponseEntity.ok(this.machineRepository.save(newTester));
    }

    @GetMapping
    public ResponseEntity<List<Machine>> show() {
        return ResponseEntity.ok(this.machineRepository.findAll());
    }

}
