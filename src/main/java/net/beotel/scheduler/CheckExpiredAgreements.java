package net.beotel.scheduler;

import net.beotel.models.Agreement;
import net.beotel.models.AgreementStatus;
import net.beotel.repository.AgreementRepository;
import net.beotel.repository.AgreementStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class CheckExpiredAgreements {

    @Autowired
    private AgreementRepository agreementRepository;
    @Autowired
    private AgreementStatusRepository agreementStatusRepository;

    @Scheduled(cron = "0 0 12 * * ?")
    private void checkExpiredAgreements() {
        List<Agreement> expireingAgreements = agreementRepository.findAllByAgreementStatus_IdAndDateExpireBefore(3, new Date());
        AgreementStatus agreementStatus = agreementStatusRepository.getOne(4);
        for(Agreement agr: expireingAgreements) {
            agr.setAgreementStatus(agreementStatus);
            agreementRepository.save(agr);
        }
    }
}
