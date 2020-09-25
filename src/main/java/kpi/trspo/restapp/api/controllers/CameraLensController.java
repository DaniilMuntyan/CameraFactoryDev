package kpi.trspo.restapp.api.controllers;

import kpi.trspo.restapp.services.models.camera.CameraLens;
import kpi.trspo.restapp.services.repositories.CameraLensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CameraLensController {

    @Autowired
    private CameraLensRepository cameraLensRepository;

    @PostMapping("camera_lens")
    public CameraLens createCameraLens(@RequestBody CameraLens cameraLens) {
        System.out.println("!!!!!");
        System.out.println(cameraLens);
        return this.cameraLensRepository.save(cameraLens);
    }

    @GetMapping("camera_lens")
    public List<CameraLens> getAllCameraLens() {
        return this.cameraLensRepository.findAll();
    }
}
