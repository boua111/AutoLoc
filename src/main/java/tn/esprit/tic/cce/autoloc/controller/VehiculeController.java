package tn.esprit.tic.cce.autoloc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.tic.cce.autoloc.domain.Vehicule;
import tn.esprit.tic.cce.autoloc.service.IVehiculeService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/vehicules")
@RequiredArgsConstructor
public class VehiculeController {
    private final IVehiculeService vehiculeService;

    @GetMapping
    public ResponseEntity<List<Vehicule>> retrieveAllVehicules() {
        return ResponseEntity.ok(vehiculeService.retrieveAllVehicules());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicule> retrieveVehicule(@PathVariable Long id) {
        Vehicule vehicule = vehiculeService.retrieveVehicule(id);
        return vehicule == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(vehicule);
    }

    @PostMapping
    public ResponseEntity<Vehicule> addVehicule(@RequestBody Vehicule vehicule) {
        Vehicule created = vehiculeService.addVehicule(vehicule);
        return ResponseEntity.created(URI.create("/api/vehicules/" + created.getIdVehicule())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicule> updateVehicule(@PathVariable Long id, @RequestBody Vehicule vehicule) {
        if (vehiculeService.retrieveVehicule(id) == null) {
            return ResponseEntity.notFound().build();
        }
        vehicule.setIdVehicule(id);
        return ResponseEntity.ok(vehiculeService.updateVehicule(vehicule));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeVehicule(@PathVariable Long id) {
        if (vehiculeService.retrieveVehicule(id) == null) {
            return ResponseEntity.notFound().build();
        }
        vehiculeService.removeVehicule(id);
        return ResponseEntity.noContent().build();
    }
}
