package kpi.trspo.restapp.api.dto.camera_dto;

import kpi.trspo.restapp.entities.camera.LensType;
import lombok.Data;

@Data
public final class CameraLensDTO {
    private Integer focalLength;
    private LensType lensType;
}
