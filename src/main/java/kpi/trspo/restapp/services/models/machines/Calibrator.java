package kpi.trspo.restapp.services.models.machines;

import kpi.trspo.restapp.services.models.camera.Camera;
import kpi.trspo.restapp.services.models.camera.CameraBack;
import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Random;

@Entity
@DiscriminatorValue("CALIBRATOR")

@Data
@NoArgsConstructor
public final class Calibrator extends Machine {

    public boolean checkMatrix(CameraBack cameraBack) {
        Random rnd = new Random();
        Boolean matrixCheck = rnd.nextInt(10) != 0; // Probability of defect: 1/10
        cameraBack.setMatrixCheck(matrixCheck);
        return matrixCheck;
    }

    public String innerCharacteristics(Camera camera) {
        Random rand = new Random();

        Double lensAngleOfView = 10 + (180 - 10) * rand.nextDouble();
        Double lensSpeed = 0 + 11 * rand.nextDouble();
        Double depthOfField = 2 + 18 * rand.nextDouble();

        String colorInfo = "Lens angle of view: " + lensAngleOfView.toString() + "\nLens speed: " +
                lensSpeed.toString() + "\nDepth of field: " + depthOfField.toString();
        return colorInfo;
    }

    @Override
    public String toString() {
        return "Calibration machine id: " + getId() + "\nName: " + getName();
    }
}
