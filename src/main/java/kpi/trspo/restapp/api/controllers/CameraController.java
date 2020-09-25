package kpi.trspo.restapp.api.controllers;

import kpi.trspo.restapp.services.models.camera.Camera;
import kpi.trspo.restapp.services.models.camera.CameraBack;
import kpi.trspo.restapp.services.repositories.CameraBackRepository;
import kpi.trspo.restapp.services.repositories.CameraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CameraController {

    @Autowired
    private CameraRepository cameraRepository;

    @PostMapping("camera")
    public Camera createCamera(@RequestBody Camera camera) {
        System.out.println("!!!!!");
        System.out.println(camera);
        return this.cameraRepository.save(camera);
    }

    @GetMapping("cameras")
    public List<Camera> getAllCameras() {
        return this.cameraRepository.findAll();
    }

}
