package kpi.trspo.restapp.services;

import kpi.trspo.restapp.services.models.camera.Camera;
import kpi.trspo.restapp.services.models.employees.Technician;
import kpi.trspo.restapp.services.models.machines.Packer;

public final class FinalStageService {

    private final PackingService packingService;

    public FinalStageService() {
        packingService = new PackingService();
    }

    public void flash(Technician technician, Camera camera) {
        technician.flash(camera);
        System.out.println("Technician " + technician.getName() + " " + technician.getSurname() + " has flashed " +
                "camera " + camera.getCamera_id());
    }

    public void clean(Technician technician, Camera camera) {
        technician.clean(camera);
        System.out.println("Technician " + technician.getName() + " " + technician.getSurname() + " has cleaned " +
                "camera " + camera.getCamera_id());
    }

    public Boolean checkDefects(Technician technician, Camera camera) {
        if(!camera.getIsRejected()) {
            return false;
        }
        technician.reject(camera);
        System.out.println("Technician " + technician.getName() + " " + technician.getSurname() + " has rejected " +
                "camera " + camera.getCamera_id());
        return true;
    }

    public void packCamera(Packer packer, Camera camera) {
        packingService.pack(packer, camera);
    }

}
