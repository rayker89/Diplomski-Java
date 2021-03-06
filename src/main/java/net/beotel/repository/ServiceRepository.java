package net.beotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.beotel.models.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Integer>{
	
}
