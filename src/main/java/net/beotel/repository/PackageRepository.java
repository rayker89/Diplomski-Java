package net.beotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.beotel.models.Package;


@Repository
public interface PackageRepository extends JpaRepository<Package, Integer>{
	
}
