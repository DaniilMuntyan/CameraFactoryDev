package kpi.trspo.restapp.services.models.camera;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.UUID;

@Entity
@Table(name = "camera_lens")

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public final class CameraLens {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "focal_length")
    @NonNull
    private Integer focalLength;

    @Enumerated(EnumType.STRING)
    @Column(name = "lens_type")
    @NonNull
    private LensType lensType;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cameraLens")
    private Camera camera;

    @Override
    public String toString() {
        return "Camera lens id: " + id + "\n" + "Focal length: " + focalLength + " mm\nLens type: " + lensType;
    }
}
