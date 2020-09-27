package kpi.trspo.restapp.api.controllers.camera_controllers;

import kpi.trspo.restapp.entities.camera.Camera;
import kpi.trspo.restapp.repositories.camera_repo.CameraRepository;
import kpi.trspo.restapp.services.models.CameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cameras")
public final class CameraController {

    private final CameraService cameraService;

    @Autowired
    public CameraController(CameraService cameraService) {
        this.cameraService = cameraService;
    }

    @GetMapping
    public ResponseEntity<List<Camera>> show() {
        return ResponseEntity.ok(this.cameraService.findAllCameras());
    }

}
