package net.beotel.repository;

import net.beotel.models.Agreement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AgreementRepository extends JpaRepository<Agreement, Integer> {

    List<Agreement> findAllByTechnicianStatus_IdIn(List<Integer> ids);

    List<Agreement> findAllByAgreementStatus_IdAndDateExpireBefore(int statusId, Date date);

    List<Agreement> findAllByClient_Id(int clientId);
}
