package kpi.trspo.restapp.services.models.machines;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Inheritance
@DiscriminatorColumn

@Data
@NoArgsConstructor
public class Machine {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "name")
    @NonNull
    private String name;

}
