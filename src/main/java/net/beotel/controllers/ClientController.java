package net.beotel.controllers;

import net.beotel.models.Agreement;
import net.beotel.models.Client;
import net.beotel.models.Package;
import net.beotel.models.Price;
import net.beotel.payload.response.MessageResponse;
import net.beotel.repository.AgreementRepository;
import net.beotel.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AgreementRepository agreementRepository;

    @PostMapping("/addNewClient")
    @PreAuthorize("hasRole('SALES') or hasRole('ADMIN')")
    public ResponseEntity<Client> createNewClient(@RequestBody Client newClient) {
        Client client = clientRepository.save(newClient);
        return ResponseEntity.ok().body(client);
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('SALES') or hasRole('ADMIN')")
    public Iterable<Client> findClientsList() {
        try {
            Iterable<Client> list = clientRepository.findAll(Sort.by("id"));
            return list;

        } catch (Exception e) {

        }
        return null;
    }

    @GetMapping("/getByJmbg/{jmbg}")
    @PreAuthorize("hasRole('SALES') or hasRole('ADMIN')")
    public ResponseEntity<Client> findClientByJmbg(@PathVariable String jmbg) {
        try {
            Client client = clientRepository.findByJmbg(jmbg);
            if(client != null) {
                return ResponseEntity.ok().body(client);
            }
        } catch (Exception e) {

        }
        return ResponseEntity.ok().body(null);
    }

    @DeleteMapping("/deleteClient/{id}")
    @PreAuthorize("hasRole('SALES') or hasRole('ADMIN')")
    public ResponseEntity<?> deletePackage(@PathVariable int id) {
        List<Agreement> agreementList = agreementRepository.findAllByClient_Id(id);
        if(agreementList.isEmpty()) {
            clientRepository.deleteById(id);
            return ResponseEntity.ok(1);
        } else
            return ResponseEntity.ok(0);
    }

    @PutMapping("/updateClient/{id}")
    @PreAuthorize("hasRole('SALES') or hasRole('ADMIN')")
    public ResponseEntity<Client> updatePackage(@RequestBody Client client) {
        Client updatedClient = clientRepository.save(client);
        return ResponseEntity.ok().body(updatedClient);
    }
}
