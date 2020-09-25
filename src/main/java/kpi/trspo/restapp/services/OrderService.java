package kpi.trspo.restapp.services;

import kpi.trspo.restapp.services.models.camera.Camera;
import kpi.trspo.restapp.services.models.employees.Manager;

public final class OrderService {

    public void reportAboutDefect(Manager manager, Camera camera) {
        manager.addToOrder(camera);
        System.out.println("Defect of camera (" + camera.getCamera_id() + ") has been reported to manager " +
                manager.getName() + " " + manager.getSurname());
    }

    public void orderDetails(Manager manager, Camera camera) {
        manager.orderDetailsFor(camera);
        System.out.println("Manager " + manager.getName() + " " + manager.getSurname() +
                " has ordered details for camera " + camera.getCamera_id());
    }

}
