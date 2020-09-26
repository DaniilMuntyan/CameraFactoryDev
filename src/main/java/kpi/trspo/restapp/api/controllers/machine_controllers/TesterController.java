package kpi.trspo.restapp.api.controllers.machine_controllers;

import kpi.trspo.restapp.api.dto.machine_dto.MachineDTO;
import kpi.trspo.restapp.entities.machines.Machine;
import kpi.trspo.restapp.entities.machines.Tester;
import kpi.trspo.restapp.repositories.machine_repo.TesterRepository;
import kpi.trspo.restapp.services.models.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tester")
public class TesterController {

    @Autowired
    private MachineService machineService;

    @PostMapping
    public ResponseEntity<Tester> create(@RequestBody MachineDTO machineDTO) {
        Tester newTester = new Tester(machineDTO.getName());
        return ResponseEntity.ok(this.machineService.save(newTester));
    }

    @GetMapping
    public ResponseEntity<List<Tester>> show() {
        return ResponseEntity.ok(this.machineService.findAllTesters());
    }

}
