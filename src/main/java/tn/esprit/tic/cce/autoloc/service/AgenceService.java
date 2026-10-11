package tn.esprit.tic.cce.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tic.cce.autoloc.domain.Agence;
import tn.esprit.tic.cce.autoloc.repository.AgenceRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AgenceService implements IAgenceService {
    private final AgenceRepository agenceRepository;

    public List<Agence> retrieveAllAgences() { return agenceRepository.findAll(); }
    public Agence addAgence(Agence agence) { return agenceRepository.save(agence); }
    public Agence updateAgence(Agence agence) { return agenceRepository.save(agence); }
    public Agence retrieveAgence(Long id) { return agenceRepository.findById(id).orElse(null); }
    public void removeAgence(Long id) { agenceRepository.deleteById(id); }
    public List<Agence> addAgences(List<Agence> agences) { return agenceRepository.saveAll(agences); }
}
