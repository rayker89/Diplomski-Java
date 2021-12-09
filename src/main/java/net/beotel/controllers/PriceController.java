package net.beotel.controllers;

import net.beotel.models.Package;
import net.beotel.models.Price;
import net.beotel.models.Service;
import net.beotel.payload.response.MessageResponse;
import net.beotel.repository.PackageRepository;
import net.beotel.repository.PriceRepository;
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
@RequestMapping("/api/prices")
public class PriceController {

    @Autowired
    private PriceRepository priceRepository;
    @Autowired
    private PackageRepository packageRepository;

    @PostMapping("/addNewPrice")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createNewPackage(@RequestBody Price newPrice) {
        priceRepository.save(newPrice);
        return ResponseEntity.ok(new MessageResponse("Uspesno snimljen novi paket u bazu!"));
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('SALES') or hasRole('ADMIN')")
    public Iterable<Price> findPricesList() {
        try {
            Iterable<Price> list = priceRepository.findAll(Sort.by("name"));
            return list;

        } catch (Exception e) {

        }
        return null;
    }

    @DeleteMapping("/deletePrice/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deletePrice(@PathVariable int id) {
        List<Package> packageList = packageRepository.findAllByPrice_Id(id);
        if(packageList.isEmpty()) {
            priceRepository.deleteById(id);
            return ResponseEntity.ok(1);
        } else
            return ResponseEntity.ok(0);
    }

    @GetMapping("/allByService/{id}")
    @PreAuthorize("hasRole('SALES') or hasRole('ADMIN')")
    public Iterable<Price> findPricesByService(@PathVariable int id) {
        return priceRepository.findAllByService_Id(id);
    }

}
