package kpi.trspo.restapp.api.controllers.service_controllers;

import kpi.trspo.restapp.api.dto.requests.testing.TestCamera;
import kpi.trspo.restapp.entities.camera.Camera;
import kpi.trspo.restapp.entities.machines.Machine;
import kpi.trspo.restapp.entities.machines.Tester;
import kpi.trspo.restapp.repositories.camera_repo.CameraRepository;
import kpi.trspo.restapp.services.MechanicalTestService;
import kpi.trspo.restapp.services.models.CameraService;
import kpi.trspo.restapp.services.models.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/testing")
public final class TestingController {

    @Autowired
    private MechanicalTestService mechanicalTestService;

    @PostMapping
    public ResponseEntity<Camera> test(@RequestBody TestCamera testCamera) throws Exception {
        UUID testerId = testCamera.getTesterId();
        UUID cameraId = testCamera.getCameraId();
        UUID technicianId = testCamera.getTechnicianId();

        Camera camera = this.mechanicalTestService.testCamera(testerId, cameraId, technicianId);

        return ResponseEntity.ok(camera);
    }
}
