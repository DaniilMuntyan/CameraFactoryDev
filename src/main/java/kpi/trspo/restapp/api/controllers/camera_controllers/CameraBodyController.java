package kpi.trspo.restapp.api.controllers.camera_controllers;

import kpi.trspo.restapp.entities.camera.CameraBody;
import kpi.trspo.restapp.repositories.camera_repo.CameraBodyRepository;
import kpi.trspo.restapp.services.models.CameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bodies")
public final class CameraBodyController {

    private final CameraService cameraService;

    @Autowired
    public CameraBodyController(CameraService cameraService) {
        this.cameraService = cameraService;
    }

    @GetMapping
    public ResponseEntity<List<CameraBody>> show() {
        return ResponseEntity.ok(this.cameraService.findAllCameraBodies());
    }
}
