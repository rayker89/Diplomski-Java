package net.beotel.controllers;

import net.beotel.models.Agreement;
import net.beotel.payload.response.MessageResponse;
import net.beotel.repository.AgreementRepository;
import net.beotel.repository.AgreementStatusRepository;
import net.beotel.repository.TechnicianStatusRepository;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/agreements")
public class AgreementController {

    @Autowired
    private AgreementRepository agreementRepository;
    @Autowired
    private TechnicianStatusRepository technicianStatusRepository;
    @Autowired
    private AgreementStatusRepository agreementStatusRepository;

    @PostMapping("/addNewAgreement")
    @PreAuthorize("hasRole('SALES') or hasRole('ADMIN')")
    public ResponseEntity<?> createNewAgreement(@RequestBody Agreement newAgreement) {
        agreementRepository.save(newAgreement);
        return ResponseEntity.ok(new MessageResponse("Uspesno kreiran novi ugovor u bazu!"));
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('USER') or hasRole('SALES') or hasRole('TECHNICIAN') or hasRole('ADMIN')")
    public Iterable<Agreement> getAllAgreement() {
        try{
            Iterable<Agreement> agreementsList = agreementRepository.findAll();
            return agreementsList;
        }catch (Exception e) {

        }
        return null;
    }

    @GetMapping("/getOne/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('SALES') or hasRole('TECHNICIAN') or hasRole('ADMIN')")
    public Agreement getAgreementById(@PathVariable int id) {
        try{
            Agreement agreement = agreementRepository.findById(id).get();
            return agreement;
        }catch (Exception e) {

        }
        return null;
    }

    @GetMapping("/allTm")
    @PreAuthorize("hasRole('TECHNICIAN') or hasRole('ADMIN')")
    public Iterable<Agreement> getAllAgreementByTechStatusStartingIds() {
        List<Integer> idList = new ArrayList<>();
        idList.add(1);
        idList.add(2);
        idList.add(3);
        idList.add(10);
        try{
            Iterable<Agreement> agreementsList = agreementRepository.findAllByTechnicianStatus_IdIn(idList);
            return agreementsList;
        }catch (Exception e) {

        }
        return null;
    }

    @GetMapping("/allSigning")
    @PreAuthorize("hasRole('SALES') or hasRole('ADMIN')")
    public Iterable<Agreement> getAllAgreementByTechStatusSigningIds() {
        List<Integer> idList = new ArrayList<>();
        idList.add(2);
        idList.add(4);
        idList.add(5);
        idList.add(6);
        try{
            Iterable<Agreement> agreementsList = agreementRepository.findAllByTechnicianStatus_IdIn(idList);
            return agreementsList;
        }catch (Exception e) {

        }
        return null;
    }

    @GetMapping("/allRealization")
    @PreAuthorize("hasRole('TECHNICIAN') or hasRole('ADMIN')")
    public Iterable<Agreement> getAllAgreementByTechStatusRealizationIds() {
        List<Integer> idList = new ArrayList<>();
        idList.add(5);
        idList.add(7);
        idList.add(8);
        idList.add(9);
        try{
            Iterable<Agreement> agreementsList = agreementRepository.findAllByTechnicianStatus_IdIn(idList);
            return agreementsList;
        }catch (Exception e) {

        }
        return null;
    }

    @DeleteMapping("/deleteAgreement/{id}")
    @PreAuthorize("hasRole('SALES') or hasRole('ADMIN')")
    public ResponseEntity<?> deleteAgreement(@PathVariable int id) {
        Agreement agreement = agreementRepository.getOne(id);


        if(agreement.getAgreementStatus().getId() == 1 || agreement.getAgreementStatus().getId() == 4) {
            agreementRepository.deleteById(id);
            return ResponseEntity.ok(1);
        } else
            return ResponseEntity.ok(0);
    }

    @PutMapping("/changeTechStatus/{techStatusId}")
    @PreAuthorize("hasRole('TECHNICIAN')  or hasRole('SALES') or hasRole('ADMIN')")
    public int updatePackage(@RequestBody Agreement agr, @PathVariable int techStatusId) {
        Agreement agreementTemp = agreementRepository.getOne(agr.getId());
        agreementTemp.setTechnicianStatus(technicianStatusRepository.getOne(techStatusId));
        if(techStatusId == 5) {
            Date dateSigned = new Date();
            //Date dateExpire = DateUtils.addMonths(new Date(), Integer.valueOf(agreementTemp.getPack().getDurationMonths()));
            agreementTemp.setAgreementStatus(agreementStatusRepository.getOne(2));
            agreementTemp.setDateSigned(dateSigned);

        } else if (techStatusId == 6) {
            agreementTemp.setAgreementStatus(agreementStatusRepository.getOne(4));
        }
        else if (techStatusId == 8) {
            Date dateExpire = DateUtils.addMonths(new Date(), Integer.valueOf(agreementTemp.getPack().getDurationMonths()));
            agreementTemp.setAgreementStatus(agreementStatusRepository.getOne(3));
            agreementTemp.setDateExpire(dateExpire);
        }
        try{
            Agreement updatedAgreement = agreementRepository.save(agreementTemp);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

}
