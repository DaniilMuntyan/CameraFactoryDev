package kpi.trspo.restapp.services;

import javafx.util.Pair;
import kpi.trspo.restapp.entities.camera.Camera;
import kpi.trspo.restapp.entities.employees.Technician;
import kpi.trspo.restapp.entities.machines.Tester;
import kpi.trspo.restapp.services.models.CameraService;
import kpi.trspo.restapp.services.models.EmployeeService;
import kpi.trspo.restapp.services.models.MachineService;
import kpi.trspo.restapp.services.validation.ValidService;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public final class MechanicalTestService {

    @Autowired
    private MachineService machineService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CameraService cameraService;

    @Autowired
    private ValidService validService;

    public Camera testCamera(UUID testerId, UUID cameraId, UUID technicianId) throws Exception {
        Pair<Tester, Camera> tester_camera = this.getTesterAndCamera(testerId, cameraId);
        Tester tester = tester_camera.getKey();
        Camera camera = tester_camera.getValue();
        Technician technician = this.getTechnician(technicianId);

        Boolean dimensionsCheck = tester.checkDimensions(camera.getCameraBack());
        Boolean autoFocusCheck = tester.checkAutofocus(camera);
        Boolean audioCheck = technician.checkAudioSystem(camera);

        if(!dimensionsCheck || !autoFocusCheck || !audioCheck) {
            camera.setIsRejected(true);
        }

        return this.cameraService.save(camera);
    }

    private Technician getTechnician(UUID technicianId) throws Exception {
        this.validService.checkValidId(technicianId, Technician.class);

        Technician technician = this.employeeService.findTechnician(technicianId);

        this.validService.checkObjectNotFound(technician, technicianId);

        return technician;
    }

    private Pair<Tester, Camera> getTesterAndCamera(UUID testerId, UUID cameraId) throws Exception {
        this.validService.checkValidId(testerId, Tester.class);
        this.validService.checkValidId(cameraId, Camera.class);

        Tester tester = this.machineService.findTester(testerId);
        Camera camera = this.cameraService.findCamera(cameraId);

        this.validService.checkObjectNotFound(tester, testerId);
        this.validService.checkObjectNotFound(camera, cameraId);

        return new Pair<>(tester, camera);
    }
}
