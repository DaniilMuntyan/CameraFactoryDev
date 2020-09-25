package kpi.trspo.restapp.api.controllers.service_controllers;

import javassist.NotFoundException;
import kpi.trspo.restapp.api.dto.Requests.AssembleBack;
import kpi.trspo.restapp.api.dto.Requests.AssembleBody;
import kpi.trspo.restapp.api.dto.Requests.AssembleCamera;
import kpi.trspo.restapp.api.dto.Requests.AssembleLens;
import kpi.trspo.restapp.api.dto.camera_dto.CameraBackDTO;
import kpi.trspo.restapp.api.dto.camera_dto.CameraBodyDTO;
import kpi.trspo.restapp.api.dto.camera_dto.CameraDTO;
import kpi.trspo.restapp.api.dto.camera_dto.CameraLensDTO;
import kpi.trspo.restapp.services.AssemblingService;
import kpi.trspo.restapp.services.models.camera.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/assemble/")
public class AssembleController {

    @Autowired
    private AssemblingService assemblingService;

    @PostMapping("camera_back")
    public ResponseEntity<CameraBack> assemble(@RequestBody AssembleBack assembleBack) throws NotFoundException {
        UUID collectorId = assembleBack.getCollectorId();
        Dimensions dimensions = assembleBack.getDimensions();
        Integer resolution = assembleBack.getResolution();
        Integer colorDepth = assembleBack.getColorDepth();

        CameraBack newCameraBack = this.assemblingService.assembleBack(collectorId, dimensions, resolution, colorDepth);

        return ResponseEntity.ok(this.assemblingService.save(newCameraBack));
    }

    @PostMapping("camera_body")
    public ResponseEntity<CameraBody> assemble(@RequestBody AssembleBody assembleBody) throws NotFoundException {
        UUID collectorId = assembleBody.getCollectorId();
        Dimensions dimensions = assembleBody.getDimensions();
        String color = assembleBody.getColor();

        CameraBody newCameraBody = this.assemblingService.assembleBody(collectorId, dimensions, color);

        return ResponseEntity.ok(this.assemblingService.save(newCameraBody));
    }

    @PostMapping("camera_lens")
    public ResponseEntity<CameraLens> assemble(@RequestBody AssembleLens assembleLens) throws NotFoundException {
        UUID collectorId = assembleLens.getCollectorId();
        Integer focalLength = assembleLens.getFocalLength();
        LensType lensType = assembleLens.getLensType();

        CameraLens newCameraLens = this.assemblingService.assembleLens(collectorId, focalLength, lensType);

        return ResponseEntity.ok(this.assemblingService.save(newCameraLens));
    }

    @PostMapping("camera")
    public ResponseEntity<Camera> assemble(@RequestBody AssembleCamera assembleCamera) throws NotFoundException {
        UUID collectorId = assembleCamera.getCollectorId();
        UUID cameraBackId = assembleCamera.getCameraBackId();
        UUID cameraBodyId = assembleCamera.getCameraBodyId();
        UUID cameraLensId = assembleCamera.getCameraLensId();
        System.out.println("IN CAMERA");
        Camera newCamera = this.assemblingService.assembleCamera(collectorId, cameraBackId, cameraBodyId, cameraLensId);
        return ResponseEntity.ok(this.assemblingService.save(newCamera));
    }

}
