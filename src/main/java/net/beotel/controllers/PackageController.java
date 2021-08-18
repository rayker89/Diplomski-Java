package net.beotel.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import net.beotel.models.Package;
import net.beotel.repository.ServiceRepository;
import net.beotel.repository.PackageRepository;
import net.beotel.payload.response.MessageResponse;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/packages")
public class PackageController {
	
	@Autowired
	PackageRepository packageRepository;
	ServiceRepository serviceRepository;
	
	@PostMapping("/addNewPackage")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<?> createNewPackage(@RequestBody Package newPackage) {
		packageRepository.save(newPackage);
		return ResponseEntity.ok(new MessageResponse("Uspesno snimljen novi paket u bazu!"));
	}
}
