package kpi.trspo.restapp.api.controllers.service_controllers;

import kpi.trspo.restapp.api.dto.requests.final_stage.FinalCheckDTO;
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
@RequestMapping("/api/final_stage")
public class FinalStageController {

    private final FinalStageService finalStageService;

    @Autowired
    public FinalStageController(FinalStageService finalStageService) {
        this.finalStageService = finalStageService;
    }

    @PostMapping
    public ResponseEntity<Camera> finalStageMethod(@RequestBody FinalCheckDTO finalCheckDTO) throws Exception {
        UUID technicianId = finalCheckDTO.getTechnicianId();
        UUID managerId = finalCheckDTO.getManagerId();
        UUID packerId = finalCheckDTO.getPackerId();
        UUID cameraId = finalCheckDTO.getCameraId();

        Camera camera = this.finalStageService.finalStage(technicianId, managerId, packerId, cameraId);

        return ResponseEntity.ok(camera);
    }



}
