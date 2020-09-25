package kpi.trspo.restapp.api.dto.Requests;

import kpi.trspo.restapp.services.models.camera.LensType;
import kpi.trspo.restapp.services.models.employees.Collector;
import lombok.Data;

import java.util.UUID;

@Data
public final class AssembleLens {
    private UUID collectorId;
    private Integer focalLength;
    private LensType lensType;
}
