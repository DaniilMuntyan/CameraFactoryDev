package kpi.trspo.restapp.services.models;

import kpi.trspo.restapp.entities.employees.Collector;
import kpi.trspo.restapp.entities.employees.Manager;
import kpi.trspo.restapp.entities.employees.Technician;
import kpi.trspo.restapp.repositories.employee_repo.CollectorRepository;
import kpi.trspo.restapp.repositories.employee_repo.ManagerRepository;
import kpi.trspo.restapp.repositories.employee_repo.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public final class EmployeeService {

    @Autowired
    private CollectorRepository collectorRepository;

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private TechnicianRepository technicianRepository;

    public Collector findCollector(UUID collectorId) {
        if (collectorId == null)
            return null;

        return this.collectorRepository.findById(collectorId).orElse(null);
    }

    public Technician findTechnician(UUID technicianId) {
        if (technicianId == null)
            return null;

        return this.technicianRepository.findById(technicianId).orElse(null);
    }

    public Manager findManager(UUID managerId) {
        if (managerId == null)
            return null;

        return this.managerRepository.findById(managerId).orElse(null);
    }

    public List<Collector> findAllColectors() {
        return this.collectorRepository.findAll();
    }

    public List<Manager> findAllManagers() {
        return this.managerRepository.findAll();
    }

    public List<Technician> findAllTechician() {
        return this.technicianRepository.findAll();
    }

    public Collector save(Collector collector) {
        return this.collectorRepository.save(collector);
    }

    public Manager save(Manager manager) {
        return this.managerRepository.save(manager);
    }

    public Technician save(Technician technician) {
        return this.technicianRepository.save(technician);
    }

}
