package kpi.trspo.restapp.services.models.employees;

import kpi.trspo.restapp.services.models.camera.Camera;
import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Random;

@Entity
@Data
public final class Technician extends Employee {

    public Technician(String name, String surname, String phone) {
        super(name, surname, phone);
    }

    public boolean checkAudioSystem(Camera camera) {
        Boolean isDefected = new Random().nextInt(10) == 0; // Probability of defect: 1/10
        return !isDefected;
    }

    public void flash(Camera camera) {
        camera.setIsFirmware(true);
    }

    public void clean(Camera camera) {
        camera.setIsWipedClean(true);
    }

    public void reject(Camera camera) {
        camera.setIsRejected(true);
    }

    @Override
    public String toString() {
        return "Technician " + getName() + " " + getSurname() + "\nID: " +  getId() + "\nPhone number: " + getPhone();
    }

}
