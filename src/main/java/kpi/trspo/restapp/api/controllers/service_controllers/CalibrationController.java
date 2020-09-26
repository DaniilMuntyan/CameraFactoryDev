package kpi.trspo.restapp.api.controllers.service_controllers;


import kpi.trspo.restapp.api.dto.requests.calibration.CalibrateCamera;
import kpi.trspo.restapp.services.CalibrationService;
import kpi.trspo.restapp.entities.camera.Camera;
import kpi.trspo.restapp.services.models.CameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/calibrate")
public class CalibrationController {

    @Autowired
    private CalibrationService calibrationService;

    @PostMapping
    public ResponseEntity<Camera> calibrate(@RequestBody CalibrateCamera calibrateCamera) throws Exception {
        UUID cameraId = calibrateCamera.getCameraId();
        UUID calibratorId = calibrateCamera.getCalibratorId();

        Camera camera = this.calibrationService.calibrateCamera(calibratorId, cameraId);

        return ResponseEntity.ok(camera);
    }

}
