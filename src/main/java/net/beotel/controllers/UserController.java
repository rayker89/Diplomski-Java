package net.beotel.controllers;

import net.beotel.models.User;
import net.beotel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.AssertFalse;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	UserRepository userRepository;

	@GetMapping("/all")
	public String allAccess() {
		return "Dobrodosli na inter.NET";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('SALES') or hasRole('TECHNICIAN') or hasRole('ADMIN')") //ovu anotaciju mozemo da koristimo zahvaljujuci @EnableGlobalMethodSecurity(prePostEnabled = true)
	public String userAccess() {												// iz WebSecurity konfiguracije!
		return "User Content.";
	}
	
	@GetMapping("/admin/allOperators")
	@PreAuthorize("hasRole('ADMIN')")
	public List<User> getAllOperators() {
		return userRepository.findAll();
	}

	@PostMapping("/admin/addNewOperator")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> createNewOperator(@RequestBody User user) {
		userRepository.save(user);
		return ResponseEntity.ok("Uspesno kreiran novi Operator");
	}

	@DeleteMapping("/admin/deleteOperator/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public int deleteOperatorById(@PathVariable long id) {
		try {
			userRepository.deleteById(id);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
}
