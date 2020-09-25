package kpi.trspo.restapp.api.controllers.employee_controllers;

import kpi.trspo.restapp.api.dto.employee_dto.EmployeeDTO;
import kpi.trspo.restapp.services.models.employees.Technician;
import kpi.trspo.restapp.services.repositories.ManagerRepository;
import kpi.trspo.restapp.services.repositories.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technician")
public final class TechnicianController {

    @Autowired
    private TechnicianRepository technicianRepository;

    @PostMapping
    public ResponseEntity<Technician> create(@RequestBody EmployeeDTO employeeDTO) {
        Technician newTechnician = new Technician(employeeDTO.getName(), employeeDTO.getSurname(),
                employeeDTO.getPhone());
        return ResponseEntity.ok(this.technicianRepository.save(newTechnician));
    }

    @GetMapping
    public ResponseEntity<List<Technician>> show() {
        return ResponseEntity.ok(this.technicianRepository.findAll());
    }

}
