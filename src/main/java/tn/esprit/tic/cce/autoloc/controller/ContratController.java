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
import tn.esprit.tic.cce.autoloc.domain.Contrat;
import tn.esprit.tic.cce.autoloc.service.IContratService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/contrats")
@RequiredArgsConstructor
public class ContratController {
    private final IContratService contratService;

    @GetMapping
    public ResponseEntity<List<Contrat>> retrieveAllContrats() {
        return ResponseEntity.ok(contratService.retrieveAllContrats());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contrat> retrieveContrat(@PathVariable Long id) {
        Contrat contrat = contratService.retrieveContrat(id);
        return contrat == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(contrat);
    }

    @PostMapping
    public ResponseEntity<Contrat> addContrat(@RequestBody Contrat contrat) {
        Contrat created = contratService.addContrat(contrat);
        return ResponseEntity.created(URI.create("/api/contrats/" + created.getIdContrat())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contrat> updateContrat(@PathVariable Long id, @RequestBody Contrat contrat) {
        if (contratService.retrieveContrat(id) == null) {
            return ResponseEntity.notFound().build();
        }
        contrat.setIdContrat(id);
        return ResponseEntity.ok(contratService.updateContrat(contrat));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeContrat(@PathVariable Long id) {
        if (contratService.retrieveContrat(id) == null) {
            return ResponseEntity.notFound().build();
        }
        contratService.removeContrat(id);
        return ResponseEntity.noContent().build();
    }
}
