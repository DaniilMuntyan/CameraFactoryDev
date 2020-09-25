package kpi.trspo.restapp.services.models.camera;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import kpi.trspo.restapp.services.models.employees.Manager;
import lombok.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "cameras")

@Data
public final class Camera {
    @Id
    @GeneratedValue
    private UUID camera_id;

    private String innerInfo;

    private Boolean isPacked = false;
    private Boolean isFirmware = false;
    private Boolean isWipedClean = false;
    private Boolean isRejected = false;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "back_id")
    private final CameraBack cameraBack;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "body_id")
    private final CameraBody cameraBody;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "lens_id")
    private final CameraLens cameraLens;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;

    @Override
    public String toString() {
        String packing = isPacked ? "Packed" : "Unpacked";
        String flashing = isFirmware ? "flashed" : "unflashed";
        String cleaning = isWipedClean ? "wiped" : "not wiped";

        String string = (packing + ", "  + cleaning + ", " +  flashing + " camera " + camera_id + "\n" + cameraBack + "\n" +
                cameraBody + "\n" + cameraLens);
        return string;
    }
}
