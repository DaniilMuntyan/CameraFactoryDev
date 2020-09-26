package kpi.trspo.restapp.api.controllers.employee_controllers;

import kpi.trspo.restapp.api.dto.employee_dto.EmployeeDTO;
import kpi.trspo.restapp.entities.employees.Collector;
import kpi.trspo.restapp.entities.employees.Employee;
import kpi.trspo.restapp.repositories.employee_repo.CollectorRepository;
import kpi.trspo.restapp.services.models.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/collector")
public final class CollectorController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Collector> create(@RequestBody EmployeeDTO employeeDTO) {
        Collector newCollector = new Collector(employeeDTO.getName(), employeeDTO.getSurname(),
                employeeDTO.getPhone());
        return ResponseEntity.ok(this.employeeService.save(newCollector));
    }

    @GetMapping
    public ResponseEntity<List<Collector>> show() {
        return ResponseEntity.ok(this.employeeService.findAllColectors());
    }

}
