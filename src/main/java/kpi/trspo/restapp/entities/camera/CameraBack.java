package kpi.trspo.restapp.entities.camera;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
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

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cameraBack", orphanRemoval = true)
    @JoinColumn(name = "camera_id")
    private Camera camera;

    @Override
    public String toString() {
        Dimensions dim = new Dimensions();
        return "Camera back id: " + id + "\nDimensions: " + dimensions + "\nResolution: " + resolution +
                " MP\nColor depth: " + colorDepth + " bpp";
    }
}
