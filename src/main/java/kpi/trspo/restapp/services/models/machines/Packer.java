package kpi.trspo.restapp.services.models.machines;

import kpi.trspo.restapp.services.models.camera.Camera;
import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PACKER")

@Data
@NoArgsConstructor
public final class Packer extends Machine {

    public boolean pack(Camera camera) {
        if(camera.getIsRejected())
            return false;

        camera.setIsPacked(true);

        return true;
    }

    @Override
    public String toString() {
        return "Packing machine id: " + getId() + "\nName: " + getName();
    }

}
