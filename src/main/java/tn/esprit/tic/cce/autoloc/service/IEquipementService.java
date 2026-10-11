package tn.esprit.tic.cce.autoloc.service;

import tn.esprit.tic.cce.autoloc.domain.Equipement;
import java.util.List;

public interface IEquipementService {
    List<Equipement> retrieveAllEquipements();
    Equipement addEquipement(Equipement equipement);
    Equipement updateEquipement(Equipement equipement);
    Equipement retrieveEquipement(Long id);
    void removeEquipement(Long id);
    List<Equipement> addEquipements(List<Equipement> equipements);
}
