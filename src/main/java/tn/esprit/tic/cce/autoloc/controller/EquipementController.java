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
import tn.esprit.tic.cce.autoloc.domain.Equipement;
import tn.esprit.tic.cce.autoloc.service.IEquipementService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/equipements")
@RequiredArgsConstructor
public class EquipementController {
    private final IEquipementService equipementService;

    @GetMapping
    public ResponseEntity<List<Equipement>> retrieveAllEquipements() {
        return ResponseEntity.ok(equipementService.retrieveAllEquipements());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipement> retrieveEquipement(@PathVariable Long id) {
        Equipement equipement = equipementService.retrieveEquipement(id);
        return equipement == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(equipement);
    }

    @PostMapping
    public ResponseEntity<Equipement> addEquipement(@RequestBody Equipement equipement) {
        Equipement created = equipementService.addEquipement(equipement);
        return ResponseEntity.created(URI.create("/api/equipements/" + created.getIdEquipement())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipement> updateEquipement(@PathVariable Long id, @RequestBody Equipement equipement) {
        if (equipementService.retrieveEquipement(id) == null) {
            return ResponseEntity.notFound().build();
        }
        equipement.setIdEquipement(id);
        return ResponseEntity.ok(equipementService.updateEquipement(equipement));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeEquipement(@PathVariable Long id) {
        if (equipementService.retrieveEquipement(id) == null) {
            return ResponseEntity.notFound().build();
        }
        equipementService.removeEquipement(id);
        return ResponseEntity.noContent().build();
    }
}
