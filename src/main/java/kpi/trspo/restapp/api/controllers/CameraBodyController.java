package kpi.trspo.restapp.api.controllers;

import kpi.trspo.restapp.services.models.camera.CameraBack;
import kpi.trspo.restapp.services.models.camera.CameraBody;
import kpi.trspo.restapp.services.repositories.CameraBackRepository;
import kpi.trspo.restapp.services.repositories.CameraBodyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CameraBodyController {

    @Autowired
    private CameraBodyRepository cameraBodyRepository;

    @PostMapping("camera_body")
    public CameraBody createCameraBody(@RequestBody CameraBody cameraBody) {
        System.out.println("!!!!!");
        System.out.println(cameraBody);
        return this.cameraBodyRepository.save(cameraBody);
    }

    @GetMapping("camera_bodies")
    public List<CameraBody> getAllCameraBodies() {
        return this.cameraBodyRepository.findAll();
    }
}
