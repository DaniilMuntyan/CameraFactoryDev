package kpi.trspo.restapp.api.dto.Requests;

import kpi.trspo.restapp.services.models.camera.Dimensions;
import kpi.trspo.restapp.services.models.employees.Collector;
import lombok.Data;

import java.util.UUID;

@Data
public final class AssembleBack {
    private UUID collectorId;
    private Dimensions dimensions;
    private Integer resolution;
    private Integer colorDepth;
}
