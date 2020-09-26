package kpi.trspo.restapp.api.dto.camera_dto;

import kpi.trspo.restapp.entities.camera.Dimensions;
import lombok.Data;

@Data
public final class CameraBodyDTO {
    private Dimensions dimensions;
    private String color;
}
