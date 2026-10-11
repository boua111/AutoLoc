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
import tn.esprit.tic.cce.autoloc.domain.Maintenance;
import tn.esprit.tic.cce.autoloc.service.IMaintenanceService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/maintenances")
@RequiredArgsConstructor
public class MaintenanceController {
    private final IMaintenanceService maintenanceService;

    @GetMapping
    public ResponseEntity<List<Maintenance>> retrieveAllMaintenances() {
        return ResponseEntity.ok(maintenanceService.retrieveAllMaintenances());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Maintenance> retrieveMaintenance(@PathVariable Long id) {
        Maintenance maintenance = maintenanceService.retrieveMaintenance(id);
        return maintenance == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(maintenance);
    }

    @PostMapping
    public ResponseEntity<Maintenance> addMaintenance(@RequestBody Maintenance maintenance) {
        Maintenance created = maintenanceService.addMaintenance(maintenance);
        return ResponseEntity.created(URI.create("/api/maintenances/" + created.getIdMaintenance())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Maintenance> updateMaintenance(@PathVariable Long id, @RequestBody Maintenance maintenance) {
        if (maintenanceService.retrieveMaintenance(id) == null) {
            return ResponseEntity.notFound().build();
        }
        maintenance.setIdMaintenance(id);
        return ResponseEntity.ok(maintenanceService.updateMaintenance(maintenance));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeMaintenance(@PathVariable Long id) {
        if (maintenanceService.retrieveMaintenance(id) == null) {
            return ResponseEntity.notFound().build();
        }
        maintenanceService.removeMaintenance(id);
        return ResponseEntity.noContent().build();
    }
}
