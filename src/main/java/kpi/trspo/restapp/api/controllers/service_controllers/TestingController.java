package kpi.trspo.restapp.api.controllers.service_controllers;

import kpi.trspo.restapp.api.dto.requests.testing.TestCameraDTO;
import kpi.trspo.restapp.entities.camera.Camera;
import kpi.trspo.restapp.services.MechanicalTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/test")
public final class TestingController {

    private final MechanicalTestService mechanicalTestService;

    @Autowired
    public TestingController(MechanicalTestService mechanicalTestService) {
        this.mechanicalTestService = mechanicalTestService;
    }

    @PostMapping
    public ResponseEntity<Camera> test(@RequestBody TestCameraDTO testCameraDTO) throws Exception {
        UUID testerId = testCameraDTO.getTesterId();
        UUID cameraId = testCameraDTO.getCameraId();
        UUID technicianId = testCameraDTO.getTechnicianId();

        Camera camera = this.mechanicalTestService.testCamera(testerId, cameraId, technicianId);

        return ResponseEntity.ok(camera);
    }
}
