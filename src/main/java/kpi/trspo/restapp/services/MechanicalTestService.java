package kpi.trspo.restapp.services;

import kpi.trspo.restapp.services.models.camera.Camera;
import kpi.trspo.restapp.services.models.employees.Technician;
import kpi.trspo.restapp.services.models.machines.Tester;

public final class MechanicalTestService {

    public void checkDimensions(Tester tester, Camera camera) {
        Boolean dimensionsCheck = tester.checkDimensions(camera.getCameraBack());

        if(!dimensionsCheck) {
            camera.setIsRejected(true);
        }

        String checkingResult = dimensionsCheck ? "success" : "fail";
        System.out.println("Tester " + tester.getName() + " has checked dimensions of camera " + camera.getCamera_id() +
                ": " + checkingResult);
    }

    public void checkAutoFocus(Tester tester, Camera camera) {
        Boolean autoFocusCheck = tester.checkAutofocus(camera);

        if (!autoFocusCheck) {
            camera.setIsRejected(true);
        }

        String checkingResult = autoFocusCheck ? "success" : "fail";
        System.out.println("Tester " + tester.getName() + " has checked autofocus of camera " + camera.getCamera_id() +
                ": " + checkingResult);
    }

    public void checkAudioSystem(Technician technician, Camera camera) {
        Boolean audioCheck = technician.checkAudioSystem(camera);

        if(!audioCheck) {
            camera.setIsRejected(true);
        }

        String checkingResult = audioCheck ? "success" : "fail";
        System.out.println("Technician " + technician.getName() + " " + technician.getSurname() + " has checked " +
                "audio system of camera " + camera.getCamera_id() + ": " + checkingResult);
    }

}
