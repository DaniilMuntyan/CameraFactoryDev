package kpi.trspo.restapp.services.models.camera;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.*;
import java.util.Random;
import java.util.UUID;

@Entity
@Table(name = "camera_backs")

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public final class CameraBack {
    @Id
    @GeneratedValue
    private UUID id;

    private Boolean matrixCheck;

    @Convert(converter = DimensionsConverter.class)
    @NonNull
    private Dimensions dimensions;

    @Column(name = "resolution")
    @NonNull
    private Integer resolution;
    
    @Column(name = "color_depth")
    @NonNull
    private Integer colorDepth;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cameraBack")
    private Camera camera;

    @Override
    public String toString() {
        Dimensions dim = new Dimensions();
        return "Camera back id: " + id + "\nDimensions: " + dimensions + "\nResolution: " + resolution +
                " MP\nColor depth: " + colorDepth + " bpp";
    }
}
