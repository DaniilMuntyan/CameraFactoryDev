package kpi.trspo.restapp.api.controllers.service_controllers;


import kpi.trspo.restapp.api.dto.requests.calibration.CalibrateCameraDTO;
import kpi.trspo.restapp.services.CalibrationService;
import kpi.trspo.restapp.entities.camera.Camera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/calibrate")
public final class CalibrationController {

    private final CalibrationService calibrationService;

    @Autowired
    public CalibrationController(CalibrationService calibrationService) {
        this.calibrationService = calibrationService;
    }

    @PostMapping
    public ResponseEntity<Camera> calibrate(@RequestBody CalibrateCameraDTO calibrateCameraDTO) throws Exception {
        UUID cameraId = calibrateCameraDTO.getCameraId();
        UUID calibratorId = calibrateCameraDTO.getCalibratorId();

        Camera camera = this.calibrationService.calibrateCamera(calibratorId, cameraId);

        return ResponseEntity.ok(camera);
    }

}
