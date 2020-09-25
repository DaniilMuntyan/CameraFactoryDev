package kpi.trspo.restapp.services.models.machines;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import kpi.trspo.restapp.services.models.camera.Camera;
import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PACKER")

@Data
public final class Packer extends Machine {

    public boolean pack(Camera camera) {
        if(camera.getIsRejected())
            return false;

        camera.setIsPacked(true);

        return true;
    }

    public Packer(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Packing machine id: " + getId() + "\nName: " + getName();
    }

}
