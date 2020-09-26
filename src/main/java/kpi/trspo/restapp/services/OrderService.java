package kpi.trspo.restapp.services;

import kpi.trspo.restapp.entities.camera.Camera;
import kpi.trspo.restapp.entities.employees.Employee;
import kpi.trspo.restapp.entities.employees.Manager;
import kpi.trspo.restapp.repositories.employee_repo.ManagerRepository;
import kpi.trspo.restapp.services.models.EmployeeService;
import kpi.trspo.restapp.services.validation.ValidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public final class OrderService {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ValidService validService;

    public void reportAboutDefect(Manager manager, Camera camera) {
        manager.addToOrder(camera);
        camera.setManager(manager);
        this.employeeService.save(manager);
    }

    public Manager orderDetails(UUID managerId) throws Exception {
        this.validService.checkValidId(managerId, Manager.class);
        Manager manager = this.employeeService.findManager(managerId);
        this.validService.checkObjectNotFound(manager, managerId);

        manager.orderDetails();

        return this.employeeService.save(manager);
    }
}
