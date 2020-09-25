package kpi.trspo.restapp.api.controllers.camera_controllers;

import kpi.trspo.restapp.api.dto.camera_dto.CameraBackDTO;
import kpi.trspo.restapp.services.models.camera.CameraBack;
import kpi.trspo.restapp.services.repositories.CameraBackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/camera_back")
public final class CameraBackController {

    @Autowired
    private CameraBackRepository cameraBackRepository;

    @PostMapping
    public ResponseEntity<CameraBack> create(@RequestBody CameraBackDTO backDTO) {
        CameraBack newCameraBack = new CameraBack(backDTO.getDimensions(), backDTO.getResolution(),
                backDTO.getColorDepth());
        return ResponseEntity.ok(this.cameraBackRepository.save(newCameraBack));
    }

    @GetMapping
    public ResponseEntity<List<CameraBack>> show() {
        return ResponseEntity.ok(this.cameraBackRepository.findAll());
    }

}
