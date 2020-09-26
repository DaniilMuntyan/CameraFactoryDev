package kpi.trspo.restapp.api.dto.camera_dto;

import kpi.trspo.restapp.entities.camera.CameraBack;
import kpi.trspo.restapp.entities.camera.CameraBody;
import kpi.trspo.restapp.entities.camera.CameraLens;
import lombok.*;

@Data
public final class CameraDTO {
    private CameraBack cameraBack;
    private CameraBody cameraBody;
    private CameraLens cameraLens;
}
