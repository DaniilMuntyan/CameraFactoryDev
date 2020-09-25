package kpi.trspo.restapp.api.dto.camera_dto;

import kpi.trspo.restapp.services.models.camera.CameraBack;
import kpi.trspo.restapp.services.models.camera.CameraBody;
import kpi.trspo.restapp.services.models.camera.CameraLens;
import lombok.*;

import java.util.UUID;

@Data
public final class CameraDTO {
    private CameraBack cameraBack;
    private CameraBody cameraBody;
    private CameraLens cameraLens;
}
