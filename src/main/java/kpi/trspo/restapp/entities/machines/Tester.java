package kpi.trspo.restapp.entities.machines;

import kpi.trspo.restapp.entities.camera.Camera;
import kpi.trspo.restapp.entities.camera.CameraBack;
import kpi.trspo.restapp.entities.camera.Dimensions;
import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Random;

@Entity
@DiscriminatorValue("TESTER")

@Data
@NoArgsConstructor
public final class Tester extends Machine {

    public Tester(String name) {
        super(name);
    }

    public boolean checkDimensions(CameraBack cameraBack) {
        Dimensions standardBack = new Dimensions(25, 20, 15);
        return cameraBack.getDimensions().compareTo(standardBack) > 0;
    }

    public boolean checkAutoFocus(Camera camera) {
        Boolean isDefected = new Random().nextInt(4) == 0; // Probability of defect: 1/4
        return !isDefected; // True, if check is successful
    }
}
