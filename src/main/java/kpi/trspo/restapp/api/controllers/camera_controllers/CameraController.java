package kpi.trspo.restapp.api.controllers.camera_controllers;

import kpi.trspo.restapp.api.dto.camera_dto.CameraDTO;
import kpi.trspo.restapp.services.models.camera.Camera;
import kpi.trspo.restapp.services.repositories.CameraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cameras")
public final class CameraController {

    @Autowired
    private CameraRepository cameraRepository;

    @PostMapping
    public ResponseEntity<Camera> create(@RequestBody CameraDTO cameraDTO) {
        Camera newCamera = new Camera(cameraDTO.getCameraBack(), cameraDTO.getCameraBody(), cameraDTO.getCameraLens());
        return ResponseEntity.ok(this.cameraRepository.save(newCamera));
    }

    @GetMapping
    public ResponseEntity<List<Camera>> show() {
        return ResponseEntity.ok(this.cameraRepository.findAll());
    }

}
