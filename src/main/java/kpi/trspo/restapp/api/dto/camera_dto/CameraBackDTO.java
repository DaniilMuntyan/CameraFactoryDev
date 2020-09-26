package kpi.trspo.restapp.api.dto.camera_dto;

import kpi.trspo.restapp.entities.camera.Dimensions;
import lombok.Data;

@Data
public final class CameraBackDTO {
    private Dimensions dimensions;
    private Integer resolution;
    private Integer colorDepth;
}
