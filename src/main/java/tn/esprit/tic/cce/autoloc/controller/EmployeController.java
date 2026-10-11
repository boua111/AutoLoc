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
import tn.esprit.tic.cce.autoloc.domain.Employe;
import tn.esprit.tic.cce.autoloc.service.IEmployeService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/employes")
@RequiredArgsConstructor
public class EmployeController {
    private final IEmployeService employeService;

    @GetMapping
    public ResponseEntity<List<Employe>> retrieveAllEmployes() {
        return ResponseEntity.ok(employeService.retrieveAllEmployes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employe> retrieveEmploye(@PathVariable Long id) {
        Employe employe = employeService.retrieveEmploye(id);
        return employe == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(employe);
    }

    @PostMapping
    public ResponseEntity<Employe> addEmploye(@RequestBody Employe employe) {
        Employe created = employeService.addEmploye(employe);
        return ResponseEntity.created(URI.create("/api/employes/" + created.getIdEmploye())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employe> updateEmploye(@PathVariable Long id, @RequestBody Employe employe) {
        if (employeService.retrieveEmploye(id) == null) {
            return ResponseEntity.notFound().build();
        }
        employe.setIdEmploye(id);
        return ResponseEntity.ok(employeService.updateEmploye(employe));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeEmploye(@PathVariable Long id) {
        if (employeService.retrieveEmploye(id) == null) {
            return ResponseEntity.notFound().build();
        }
        employeService.removeEmploye(id);
        return ResponseEntity.noContent().build();
    }
}
