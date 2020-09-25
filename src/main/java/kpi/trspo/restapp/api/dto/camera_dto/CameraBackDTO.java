package kpi.trspo.restapp.api.dto.camera_dto;

import kpi.trspo.restapp.services.models.camera.Dimensions;
import lombok.Data;

import java.awt.*;
import java.util.UUID;

@Data
public final class CameraBackDTO {
    private Dimensions dimensions;
    private Integer resolution;
    private Integer colorDepth;
}
