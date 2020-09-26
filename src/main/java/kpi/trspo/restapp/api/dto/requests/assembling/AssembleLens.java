package kpi.trspo.restapp.api.dto.requests.assembling;

import kpi.trspo.restapp.entities.camera.LensType;
import lombok.Data;

import java.util.UUID;

@Data
public final class AssembleLens {
    private UUID collectorId;
    private Integer focalLength;
    private LensType lensType;
}
