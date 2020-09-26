package kpi.trspo.restapp.api.controllers.camera_controllers;

import kpi.trspo.restapp.api.dto.camera_dto.CameraBodyDTO;
import kpi.trspo.restapp.entities.camera.CameraBody;
import kpi.trspo.restapp.repositories.camera_repo.CameraBodyRepository;
import kpi.trspo.restapp.services.models.CameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/camera_bodies")
public final class CameraBodyController {

    @Autowired
    private CameraService cameraService;

    @PostMapping
    public ResponseEntity<CameraBody> create(@RequestBody CameraBodyDTO bodyDTO) {
        CameraBody cameraBody = new CameraBody(bodyDTO.getDimensions(), bodyDTO.getColor());
        return ResponseEntity.ok(this.cameraService.save(cameraBody));
    }

    @GetMapping
    public ResponseEntity<List<CameraBody>> show() {
        return ResponseEntity.ok(this.cameraService.findAllCameraBodies());
    }
}
