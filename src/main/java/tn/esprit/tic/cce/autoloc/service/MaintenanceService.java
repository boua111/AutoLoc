package tn.esprit.tic.cce.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tic.cce.autoloc.domain.Maintenance;
import tn.esprit.tic.cce.autoloc.repository.MaintenanceRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MaintenanceService implements IMaintenanceService {
    private final MaintenanceRepository maintenanceRepository;
    public List<Maintenance> retrieveAllMaintenances() { return maintenanceRepository.findAll(); }
    public Maintenance addMaintenance(Maintenance maintenance) { return maintenanceRepository.save(maintenance); }
    public Maintenance updateMaintenance(Maintenance maintenance) { return maintenanceRepository.save(maintenance); }
    public Maintenance retrieveMaintenance(Long id) { return maintenanceRepository.findById(id).orElse(null); }
    public void removeMaintenance(Long id) { maintenanceRepository.deleteById(id); }
    public List<Maintenance> addMaintenances(List<Maintenance> maintenances) { return maintenanceRepository.saveAll(maintenances); }
}
