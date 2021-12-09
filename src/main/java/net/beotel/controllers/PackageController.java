package net.beotel.controllers;


import net.beotel.models.Agreement;
import net.beotel.models.Package;
import net.beotel.models.Price;
import net.beotel.payload.response.MessageResponse;
import net.beotel.repository.AgreementRepository;
import net.beotel.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/packages")
public class PackageController {
	
	@Autowired
	private PackageRepository packageRepository;
	@Autowired
	private AgreementRepository agreementRepository;
	
	@PostMapping("/addNewPackage")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> createNewPackage(@RequestBody Package newPackage) {
		packageRepository.save(newPackage);
		return ResponseEntity.ok(new MessageResponse("Uspesno snimljen novi paket u bazu!"));
	}


	@GetMapping("/all")
	@PreAuthorize("hasRole('SALES') or hasRole('ADMIN')")
	public Iterable<Package> findPackagesList() {
		try {
			Iterable<Package> list = packageRepository.findAll(Sort.by("status").descending().and(Sort.by("name")));
			return list;

		} catch (Exception e) {

		}
		return null;
	}

	@GetMapping("/allByStatus/{id}")
	@PreAuthorize("hasRole('SALES') or hasRole('ADMIN')")
	public Iterable<Package> findPackagesByService(@PathVariable int id) {
		Iterable<Package> resultList = packageRepository.findByServiceIdAndStatus(id, 1);
		return resultList;
	}

	@PutMapping("/activateDeactivatePackage/{id}")
	@PreAuthorize("hasRole('SALES') or hasRole('ADMIN')")
	public ResponseEntity<Package> updatePackage(@RequestBody Package pack) {
		Package packTemp = packageRepository.getOne(pack.getId());
		packTemp.setStatus(pack.getStatus());
		Package updatedPackage = packageRepository.save(packTemp);
		return ResponseEntity.ok().body(updatedPackage);
	}

	@DeleteMapping("/deletePackage/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deletePackage(@PathVariable int id) {
		Package pack = packageRepository.getOne(id);
		Agreement tempAgreement = new Agreement();
		tempAgreement.setPack(pack);
		Example<Agreement> agreementExample = Example.of(tempAgreement);
		List<Agreement> agreementsList = agreementRepository.findAll(agreementExample);

		if(agreementsList.isEmpty()) {
			packageRepository.deleteById(id);
			return ResponseEntity.ok(1);
		} else
			return ResponseEntity.ok(0);
	}
}
