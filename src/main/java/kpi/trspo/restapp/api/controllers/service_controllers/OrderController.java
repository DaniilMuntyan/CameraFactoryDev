package kpi.trspo.restapp.api.controllers.service_controllers;

import kpi.trspo.restapp.api.dto.requests.order.OrderDetailDTO;
import kpi.trspo.restapp.entities.employees.Manager;
import kpi.trspo.restapp.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/order")
public final class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Manager> order(@RequestBody OrderDetailDTO orderDetailDTO) throws Exception {
        UUID managerId = orderDetailDTO.getManagerId();

        Manager manager = this.orderService.orderDetails(managerId);
        return ResponseEntity.ok(manager);
    }


}
