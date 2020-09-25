package kpi.trspo.restapp.services.repositories;

import kpi.trspo.restapp.services.models.camera.CameraLens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CameraLensRepository extends JpaRepository<CameraLens, UUID> {

}
