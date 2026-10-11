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
import tn.esprit.tic.cce.autoloc.domain.Paiement;
import tn.esprit.tic.cce.autoloc.service.IPaiementService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/paiements")
@RequiredArgsConstructor
public class PaiementController {
    private final IPaiementService paiementService;

    @GetMapping
    public ResponseEntity<List<Paiement>> retrieveAllPaiements() {
        return ResponseEntity.ok(paiementService.retrieveAllPaiements());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paiement> retrievePaiement(@PathVariable Long id) {
        Paiement paiement = paiementService.retrievePaiement(id);
        return paiement == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(paiement);
    }

    @PostMapping
    public ResponseEntity<Paiement> addPaiement(@RequestBody Paiement paiement) {
        Paiement created = paiementService.addPaiement(paiement);
        return ResponseEntity.created(URI.create("/api/paiements/" + created.getIdPaiement())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paiement> updatePaiement(@PathVariable Long id, @RequestBody Paiement paiement) {
        if (paiementService.retrievePaiement(id) == null) {
            return ResponseEntity.notFound().build();
        }
        paiement.setIdPaiement(id);
        return ResponseEntity.ok(paiementService.updatePaiement(paiement));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removePaiement(@PathVariable Long id) {
        if (paiementService.retrievePaiement(id) == null) {
            return ResponseEntity.notFound().build();
        }
        paiementService.removePaiement(id);
        return ResponseEntity.noContent().build();
    }
}
