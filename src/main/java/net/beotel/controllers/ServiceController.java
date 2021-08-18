package net.beotel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.beotel.models.Service;
import net.beotel.repository.ServiceRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/services")
public class ServiceController {
	
	@Autowired
	ServiceRepository serviceRepository;
	
	@GetMapping("/all")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public Iterable<Service> findServicesList() {
		try {
			Iterable<Service> list = serviceRepository.findAll(Sort.by("name"));
			return list;

		} catch (Exception e) {

		}
		return null;
	}
}
