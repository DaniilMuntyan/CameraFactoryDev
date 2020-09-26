package kpi.trspo.restapp.api.dto.requests.order;

import lombok.Data;

import java.util.UUID;

@Data
public final class OrderDetail {
    private UUID managerId;
}
