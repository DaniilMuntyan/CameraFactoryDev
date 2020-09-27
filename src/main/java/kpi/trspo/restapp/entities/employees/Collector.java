package kpi.trspo.restapp.entities.employees;

import kpi.trspo.restapp.entities.camera.*;
import lombok.*;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public final class Collector extends Employee {

    public Camera assemble(CameraBack cameraBack, CameraBody cameraBody, CameraLens cameraLens) {
        return new Camera(cameraBack, cameraBody, cameraLens);
    }

    public CameraBack assemble(Dimensions backDims, Integer resolution, Integer colorDepth) {
        return new CameraBack(backDims, resolution, colorDepth);
    }

    public CameraBody assemble(Dimensions dimensions, String color) {
        return new CameraBody(dimensions, color);
    }

    public CameraLens assemble(Integer focalLength, LensType lensType) {
        return new CameraLens(focalLength, lensType);
    }

    public Collector(String name, String surname, String phone) {
        super(name, surname, phone);
    }
}
