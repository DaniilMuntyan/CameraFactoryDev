package kpi.trspo.restapp.api.controllers.employee_controllers;

import kpi.trspo.restapp.api.dto.employee_dto.EmployeeDTO;
import kpi.trspo.restapp.services.models.employees.Collector;
import kpi.trspo.restapp.services.models.employees.Employee;
import kpi.trspo.restapp.services.models.employees.Technician;
import kpi.trspo.restapp.services.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/collector")
public final class CollectorController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public ResponseEntity<Collector> create(@RequestBody EmployeeDTO employeeDTO) {
        Collector newCollector = new Collector(employeeDTO.getName(), employeeDTO.getSurname(),
                employeeDTO.getPhone());
        return ResponseEntity.ok(this.employeeRepository.save(newCollector));
    }

    @GetMapping
    public ResponseEntity<List<Employee>> show() {
        return ResponseEntity.ok(this.employeeRepository.findAll());
    }

}
