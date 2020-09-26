package kpi.trspo.restapp.api.controllers.service_controllers;

import kpi.trspo.restapp.api.dto.requests.order.OrderDetail;
import kpi.trspo.restapp.api.dto.requests.testing.TestCamera;
import kpi.trspo.restapp.entities.camera.Camera;
import kpi.trspo.restapp.entities.employees.Manager;
import kpi.trspo.restapp.services.OrderService;
import kpi.trspo.restapp.services.validation.ValidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/order")
public final class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Manager> test(@RequestBody OrderDetail orderDetail) throws Exception {
        UUID managerId = orderDetail.getManagerId();

        Manager manager = this.orderService.orderDetails(managerId);
        return ResponseEntity.ok(manager);
    }


}
