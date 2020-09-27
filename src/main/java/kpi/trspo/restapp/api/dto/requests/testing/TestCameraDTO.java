package kpi.trspo.restapp.api.dto.requests.testing;

import lombok.Data;

import java.util.UUID;

@Data
public final class TestCameraDTO {
    private UUID testerId;
    private UUID technicianId;
    private UUID cameraId;
}
