package kpi.trspo.restapp.services.models.employees;

import com.fasterxml.jackson.annotation.JsonBackReference;
import kpi.trspo.restapp.services.models.camera.Camera;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.ArrayDeque;

@Entity
@Data
@RequiredArgsConstructor
public final class Manager extends Employee {

    //@OneToMany(targetEntity = Camera.class, cascade = CascadeType.ALL)
    //@JoinColumn(name = "defects_fk", referencedColumnName = "id")
    @OneToMany(mappedBy = "manager")
    private final List<Camera> defect_queue;

    public void orderDetailsFor(Camera camera) {
        defect_queue.remove(camera);
    }

    public void addToOrder(Camera camera) {
        defect_queue.add(camera);
    }

    public Manager(String name, String surname, String phone) {
        super(name, surname, phone);
        this.defect_queue = new ArrayList<>();
    }

    private String getDefectList() {
        String detailsToAdd = "";
        for (Camera camera: defect_queue) {
            detailsToAdd = detailsToAdd.concat(camera.getCamera_id() + "\n");
        }
        return detailsToAdd;
    }

    @Override
    public String toString() {
        return "Manager " + getName() + " " + getSurname() + "\nID: " +  getId() + "\nPhone number: " + getPhone() +
                "\nDetails to order: " + getDefectList();
    }

}
