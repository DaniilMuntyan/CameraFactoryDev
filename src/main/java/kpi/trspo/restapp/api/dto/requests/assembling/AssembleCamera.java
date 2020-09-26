package kpi.trspo.restapp.api.dto.requests.assembling;

import lombok.Data;

import java.util.UUID;

@Data
public final class AssembleCamera {
    private UUID collectorId;
    private UUID cameraBackId;
    private UUID cameraBodyId;
    private UUID cameraLensId;
}
