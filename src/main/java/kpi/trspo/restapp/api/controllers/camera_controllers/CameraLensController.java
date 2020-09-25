package kpi.trspo.restapp.api.controllers.camera_controllers;

import kpi.trspo.restapp.api.dto.camera_dto.CameraLensDTO;
import kpi.trspo.restapp.services.models.camera.CameraLens;
import kpi.trspo.restapp.services.repositories.CameraLensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/camera_lens")
public final class CameraLensController {

    @Autowired
    private CameraLensRepository cameraLensRepository;

    @PostMapping
    public ResponseEntity<CameraLens> create(@RequestBody CameraLensDTO lensDTO) {
        CameraLens newCameraLens = new CameraLens(lensDTO.getFocalLength(), lensDTO.getLensType());
        return ResponseEntity.ok(this.cameraLensRepository.save(newCameraLens));
    }

    @GetMapping
    public ResponseEntity<List<CameraLens>> show() {
        return ResponseEntity.ok(this.cameraLensRepository.findAll());
    }
}
