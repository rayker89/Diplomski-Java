package net.beotel.repository;

import net.beotel.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.beotel.models.Package;

import java.util.List;


@Repository
public interface PackageRepository extends JpaRepository<Package, Integer>{

    @Query("SELECT package from Package as package where package.service.id = :serviceId and package.status = :status")
    Iterable<Package> findByServiceIdAndStatus(int serviceId, int status);

    List<Package> findAllByPrice_Id(int priceId);
}
