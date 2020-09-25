package kpi.trspo.restapp.services.repositories;

import kpi.trspo.restapp.services.models.employees.Collector;
import kpi.trspo.restapp.services.models.employees.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CollectorRepository extends JpaRepository<Collector, UUID> {
    
}
