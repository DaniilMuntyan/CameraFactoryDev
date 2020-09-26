package kpi.trspo.restapp.api.controllers.service_controllers;

import kpi.trspo.restapp.api.dto.requests.final_stage.FinalCheck;
import kpi.trspo.restapp.entities.camera.Camera;
import kpi.trspo.restapp.services.FinalStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/final")
public class FinalStageController {

    @Autowired
    private FinalStageService finalStageService;

    @PostMapping
    public ResponseEntity<Camera> test(@RequestBody FinalCheck finalCheck) throws Exception {
        UUID technicianId = finalCheck.getTechnicianId();
        UUID managerId = finalCheck.getManagerId();
        UUID packerId = finalCheck.getPackerId();
        UUID cameraId = finalCheck.getCameraId();

        Camera camera = this.finalStageService.finalStage(technicianId, managerId, packerId, cameraId);

        return ResponseEntity.ok(camera);
    }



}
