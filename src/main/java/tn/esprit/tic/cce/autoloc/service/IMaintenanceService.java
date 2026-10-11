package tn.esprit.tic.cce.autoloc.service;

import tn.esprit.tic.cce.autoloc.domain.Maintenance;
import java.util.List;

public interface IMaintenanceService {
    List<Maintenance> retrieveAllMaintenances();
    Maintenance addMaintenance(Maintenance maintenance);
    Maintenance updateMaintenance(Maintenance maintenance);
    Maintenance retrieveMaintenance(Long id);
    void removeMaintenance(Long id);
    List<Maintenance> addMaintenances(List<Maintenance> maintenances);
}
