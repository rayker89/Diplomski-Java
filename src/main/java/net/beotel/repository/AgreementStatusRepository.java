package net.beotel.repository;

import net.beotel.models.AgreementStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgreementStatusRepository  extends JpaRepository<AgreementStatus, Integer> {

}
