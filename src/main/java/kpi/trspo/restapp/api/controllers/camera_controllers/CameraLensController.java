package kpi.trspo.restapp.api.controllers.camera_controllers;

import kpi.trspo.restapp.entities.camera.CameraLens;
import kpi.trspo.restapp.repositories.camera_repo.CameraLensRepository;
import kpi.trspo.restapp.services.models.CameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lens")
public final class CameraLensController {

    private final CameraService cameraService;

    @Autowired
    public CameraLensController(CameraService cameraService) {
        this.cameraService = cameraService;
    }

    @GetMapping
    public ResponseEntity<List<CameraLens>> show() {
        return ResponseEntity.ok(this.cameraService.findAllCameraLens());
    }
}
