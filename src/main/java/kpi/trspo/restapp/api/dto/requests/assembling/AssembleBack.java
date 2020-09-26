package kpi.trspo.restapp.api.dto.requests.assembling;

import kpi.trspo.restapp.entities.camera.Dimensions;
import lombok.Data;

import java.util.UUID;

@Data
public final class AssembleBack {
    private UUID collectorId;
    private Dimensions dimensions;
    private Integer resolution;
    private Integer colorDepth;
}
