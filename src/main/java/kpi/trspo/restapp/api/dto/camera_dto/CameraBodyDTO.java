package kpi.trspo.restapp.api.dto.camera_dto;

import kpi.trspo.restapp.services.models.camera.Dimensions;
import lombok.Data;

@Data
public final class CameraBodyDTO {
    private Dimensions dimensions;
    private String color;
}
