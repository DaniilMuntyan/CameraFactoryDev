package kpi.trspo.restapp.services.repositories;

import kpi.trspo.restapp.services.models.camera.Camera;
import kpi.trspo.restapp.services.models.employees.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CameraRepository extends JpaRepository<Camera, UUID> {

}
