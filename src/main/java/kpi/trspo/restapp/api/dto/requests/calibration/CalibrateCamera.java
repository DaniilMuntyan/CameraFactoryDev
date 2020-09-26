package kpi.trspo.restapp.api.dto.requests.calibration;

import lombok.Data;

import java.util.UUID;

@Data
public final class CalibrateCamera {
    private UUID calibratorId;
    private UUID cameraId;
}
