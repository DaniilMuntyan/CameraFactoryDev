package kpi.trspo.restapp.api.dto.Requests;

import kpi.trspo.restapp.services.models.camera.CameraBack;
import kpi.trspo.restapp.services.models.camera.CameraBody;
import kpi.trspo.restapp.services.models.camera.CameraLens;
import kpi.trspo.restapp.services.models.employees.Collector;
import lombok.Data;

import java.util.UUID;

@Data
public final class AssembleCamera {
    private UUID collectorId;
    private UUID cameraBackId;
    private UUID cameraBodyId;
    private UUID cameraLensId;
}
