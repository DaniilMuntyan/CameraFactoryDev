package kpi.trspo.restapp.api.controllers.camera_controllers;

import kpi.trspo.restapp.entities.camera.CameraBack;
import kpi.trspo.restapp.repositories.camera_repo.CameraBackRepository;
import kpi.trspo.restapp.services.models.CameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/backs")
public final class CameraBackController {

    private final CameraService cameraService;

    @Autowired
    public CameraBackController(CameraService cameraService) {
        this.cameraService = cameraService;
    }

    @GetMapping
    public ResponseEntity<List<CameraBack>> show() {
        return ResponseEntity.ok(this.cameraService.findAllCameraBacks());
    }

}