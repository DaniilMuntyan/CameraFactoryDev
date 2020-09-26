package kpi.trspo.restapp.api.controllers.machine_controllers;

import kpi.trspo.restapp.api.dto.machine_dto.MachineDTO;
import kpi.trspo.restapp.entities.machines.Packer;
import kpi.trspo.restapp.repositories.machine_repo.PackerRepository;
import kpi.trspo.restapp.services.models.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/packer")
public final class PackerController {

    @Autowired
    private MachineService machineService;

    @PostMapping
    public ResponseEntity<Packer> create(@RequestBody MachineDTO machineDTO) {
        Packer newPacker = new Packer(machineDTO.getName());
        return ResponseEntity.ok(this.machineService.save(newPacker));
    }

    @GetMapping
    public ResponseEntity<List<Packer>> show() {
        return ResponseEntity.ok(this.machineService.findAllPackers());
    }

}
