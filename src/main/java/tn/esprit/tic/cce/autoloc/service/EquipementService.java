package tn.esprit.tic.cce.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tic.cce.autoloc.domain.Equipement;
import tn.esprit.tic.cce.autoloc.repository.EquipementRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipementService implements IEquipementService {
    private final EquipementRepository equipementRepository;
    public List<Equipement> retrieveAllEquipements() { return equipementRepository.findAll(); }
    public Equipement addEquipement(Equipement equipement) { return equipementRepository.save(equipement); }
    public Equipement updateEquipement(Equipement equipement) { return equipementRepository.save(equipement); }
    public Equipement retrieveEquipement(Long id) { return equipementRepository.findById(id).orElse(null); }
    public void removeEquipement(Long id) { equipementRepository.deleteById(id); }
    public List<Equipement> addEquipements(List<Equipement> equipements) { return equipementRepository.saveAll(equipements); }
}
