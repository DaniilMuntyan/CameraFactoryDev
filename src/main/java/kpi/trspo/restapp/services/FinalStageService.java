package kpi.trspo.restapp.services;

import javafx.util.Pair;
import kpi.trspo.restapp.entities.camera.Camera;
import kpi.trspo.restapp.entities.employees.Manager;
import kpi.trspo.restapp.entities.employees.Technician;
import kpi.trspo.restapp.entities.machines.Packer;
import kpi.trspo.restapp.services.models.CameraService;
import kpi.trspo.restapp.services.models.EmployeeService;
import kpi.trspo.restapp.services.models.MachineService;
import kpi.trspo.restapp.services.validation.ValidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public final class FinalStageService {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CameraService cameraService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private MachineService machineService;

    @Autowired
    private ValidService validService;

    public void flash(Technician technician, Camera camera) {
        technician.flash(camera);
    }

    public void clean(Technician technician, Camera camera) {
        technician.clean(camera);
    }

    public void pack(Packer packer, Camera camera) {
        packer.pack(camera);
    }

    public Camera finalStage(UUID technicianId, UUID managerId, UUID packerId, UUID cameraId) throws Exception {
        Pair<Technician, Camera> technician_camera = this.getTechnicianAndCamera(technicianId, cameraId);
        Technician technician = technician_camera.getKey();
        Camera camera = technician_camera.getValue();

        Pair<Manager, Packer> manager_packer = this.getManagerAndPacker(managerId, packerId);
        Manager manager = manager_packer.getKey();
        Packer packer = manager_packer.getValue();

        if(!camera.getIsRejected()) {
            this.flash(technician, camera);
            this.clean(technician, camera);
            this.pack(packer, camera);
        } else {
            System.out.println("\n\nREJECTED!!!\n\n");
            this.orderService.reportAboutDefect(manager, camera);
        }

        return this.cameraService.save(camera);
    }

    private Pair<Manager, Packer> getManagerAndPacker(UUID managerId, UUID packerId) throws Exception {
        this.validService.checkValidId(managerId, Manager.class);
        this.validService.checkValidId(packerId, Packer.class);

        Manager manager = this.employeeService.findManager(managerId);
        Packer packer = this.machineService.findPacker(packerId);

        this.validService.checkObjectNotFound(manager, managerId);
        this.validService.checkObjectNotFound(packer, packerId);

        return new Pair<>(manager, packer);
    }

    private Pair<Technician, Camera> getTechnicianAndCamera(UUID technicianId, UUID cameraId) throws Exception {
        this.validService.checkValidId(technicianId, Technician.class);
        this.validService.checkValidId(cameraId, Camera.class);

        Technician technician = this.employeeService.findTechnician(technicianId);
        Camera camera = this.cameraService.findCamera(cameraId);

        this.validService.checkObjectNotFound(technician, technicianId);
        this.validService.checkObjectNotFound(camera, cameraId);

        return new Pair<>(technician, camera);
    }
}
