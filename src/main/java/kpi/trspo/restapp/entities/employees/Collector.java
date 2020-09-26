package kpi.trspo.restapp.entities.employees;

import kpi.trspo.restapp.entities.camera.*;
import lombok.*;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public final class Collector extends Employee {

    public Camera assemble(CameraBack cameraBack, CameraBody cameraBody, CameraLens lens) {
        return new Camera(cameraBack, cameraBody, lens);
        //return Camera.builder().back(cameraBack).cameraBody(cameraBody).lens(lens).build();
    }

    public CameraBack assemble(Dimensions backDims, Integer resolution, Integer colorDepth) {
        return new CameraBack(backDims, resolution, colorDepth);
        //return CameraBack.builder().dimensions(backDims).resolution(resolution).colorDepth(colorDepth).build();
    }

    public CameraBody assemble(Dimensions dimensions, String color) {
        return new CameraBody(dimensions, color);
        //return CameraBody.builder().color(color).dimensions(dimensions).build();
    }

   /* public CameraBody assemble(String color) {
        return new CameraBody(color);
    }*/

    public CameraLens assemble(Integer focalLength, LensType lensType) {
        return new CameraLens(focalLength, lensType);
    }

    public Collector(String name, String surname, String phone) {
        super(name, surname, phone);
    }

    @Override
    public String toString() {
        return "Collector " +  getName() + " " + getSurname() + "\nID: " +  getId() + "\nPhone number: " + getPhone();
    }
}