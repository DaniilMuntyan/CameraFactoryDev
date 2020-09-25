package kpi.trspo.restapp.api.controllers;

import kpi.trspo.restapp.services.models.camera.CameraBack;
import kpi.trspo.restapp.services.repositories.CameraBackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CameraBackController {

    @Autowired
    private CameraBackRepository cameraBackRepository;

    @PostMapping("camera_back")
    public CameraBack createCameraBack(@RequestBody CameraBack cameraBack) {
        System.out.println("!!!!!");
        System.out.println(cameraBack);
        return this.cameraBackRepository.save(cameraBack);
    }

    @GetMapping("camera_backs")
    public List<CameraBack> getAllCameraBacks() {
        return this.cameraBackRepository.findAll();
    }

}
