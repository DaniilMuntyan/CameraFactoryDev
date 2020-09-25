package kpi.trspo.restapp.services.models.machines;

import kpi.trspo.restapp.services.models.camera.Camera;
import kpi.trspo.restapp.services.models.camera.CameraBack;
import kpi.trspo.restapp.services.models.camera.Dimensions;
import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Random;

@Entity
@DiscriminatorValue("TESTER")

@Data
@NoArgsConstructor
public final class Tester extends Machine {

    public boolean checkDimensions(CameraBack cameraBack) {
        Dimensions standardBack = new Dimensions(25, 20, 15);
        return cameraBack.getDimensions().compareTo(standardBack) > 0;
    }

    public boolean checkAutofocus(Camera camera) {
        Boolean isDefected = new Random().nextInt(4) == 0; // Probability of defect: 1/4
        return !isDefected;
    }

    @Override
    public String toString() {
        return "Test machine id: " + getId() + "\nName: " + getName();
    }

}
