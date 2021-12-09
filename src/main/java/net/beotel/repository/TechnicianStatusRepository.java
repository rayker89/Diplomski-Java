package net.beotel.repository;

import net.beotel.models.TechnicianStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicianStatusRepository extends JpaRepository<TechnicianStatus, Integer> {
}
