package kpi.trspo.restapp.services.models.camera;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Random;
import java.util.UUID;

@Entity
@Table(name = "camera_bodies")

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public final class CameraBody {
    @Id
    @GeneratedValue
    private UUID id;

    @Convert(converter = DimensionsConverter.class)
    @NonNull
    private Dimensions dimensions;

    @Column(name = "color")
    @NonNull
    private String color;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cameraBody")
    private Camera camera;

    @Override
    public String toString() {
        return "Camera body id: " + id + "cm\nDimensions: " + dimensions + "\nColor: " + color;
    }

}
