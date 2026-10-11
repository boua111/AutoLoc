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
import tn.esprit.tic.cce.autoloc.domain.Agence;
import tn.esprit.tic.cce.autoloc.service.IAgenceService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/agences")
@RequiredArgsConstructor
public class AgenceController {
    private final IAgenceService agenceService;

    @GetMapping
    public ResponseEntity<List<Agence>> retrieveAllAgences() {
        return ResponseEntity.ok(agenceService.retrieveAllAgences());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agence> retrieveAgence(@PathVariable Long id) {
        Agence agence = agenceService.retrieveAgence(id);
        return agence == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(agence);
    }

    @PostMapping
    public ResponseEntity<Agence> addAgence(@RequestBody Agence agence) {
        Agence created = agenceService.addAgence(agence);
        return ResponseEntity.created(URI.create("/api/agences/" + created.getIdAgence())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agence> updateAgence(@PathVariable Long id, @RequestBody Agence agence) {
        if (agenceService.retrieveAgence(id) == null) {
            return ResponseEntity.notFound().build();
        }
        agence.setIdAgence(id);
        return ResponseEntity.ok(agenceService.updateAgence(agence));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeAgence(@PathVariable Long id) {
        if (agenceService.retrieveAgence(id) == null) {
            return ResponseEntity.notFound().build();
        }
        agenceService.removeAgence(id);
        return ResponseEntity.noContent().build();
    }
}
