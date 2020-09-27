package kpi.trspo.restapp.api.dto.requests.final_stage;

import lombok.Data;

import java.util.UUID;

@Data
public final class FinalCheckDTO {
    private UUID technicianId;
    private UUID packerId;
    private UUID managerId;
    private UUID cameraId;
}
