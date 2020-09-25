package kpi.trspo.restapp.services.repositories;

import kpi.trspo.restapp.services.models.camera.CameraBack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CameraBackRepository extends JpaRepository<CameraBack, UUID> {

}
