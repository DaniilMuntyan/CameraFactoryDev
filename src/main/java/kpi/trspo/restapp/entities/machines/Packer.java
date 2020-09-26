package kpi.trspo.restapp.entities.machines;

import kpi.trspo.restapp.entities.camera.Camera;
import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PACKER")

@Data
@NoArgsConstructor
public final class Packer extends Machine {

    public void pack(Camera camera) {
        camera.setIsPacked(true);
    }

    public Packer(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Packing machine id: " + getId() + "\nName: " + getName();
    }

}
