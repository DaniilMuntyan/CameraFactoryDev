package kpi.trspo.restapp.services.repositories;

import kpi.trspo.restapp.services.models.employees.Manager;
import kpi.trspo.restapp.services.models.employees.Technician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician, UUID> {

}
