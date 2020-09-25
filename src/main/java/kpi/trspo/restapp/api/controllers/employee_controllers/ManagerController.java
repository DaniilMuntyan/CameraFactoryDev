package kpi.trspo.restapp.api.controllers.employee_controllers;

import kpi.trspo.restapp.api.dto.employee_dto.EmployeeDTO;
import kpi.trspo.restapp.services.models.employees.Manager;
import kpi.trspo.restapp.services.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/manager")
public final class ManagerController {

    @Autowired
    private ManagerRepository managerRepository;

    @PostMapping
    public ResponseEntity<Manager> create(@RequestBody EmployeeDTO employeeDTO) {
        Manager newManager = new Manager(employeeDTO.getName(), employeeDTO.getSurname(), employeeDTO.getPhone());
        return ResponseEntity.ok(this.managerRepository.save(newManager));
    }

    @GetMapping
    public ResponseEntity<List<Manager>> show() {
        return ResponseEntity.ok(this.managerRepository.findAll());
    }

}
