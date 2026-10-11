package tn.esprit.tic.cce.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tic.cce.autoloc.domain.Contrat;
import tn.esprit.tic.cce.autoloc.repository.ContratRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContratService implements IContratService {
    private final ContratRepository contratRepository;
    public List<Contrat> retrieveAllContrats() { return contratRepository.findAll(); }
    public Contrat addContrat(Contrat contrat) { return contratRepository.save(contrat); }
    public Contrat updateContrat(Contrat contrat) { return contratRepository.save(contrat); }
    public Contrat retrieveContrat(Long id) { return contratRepository.findById(id).orElse(null); }
    public void removeContrat(Long id) { contratRepository.deleteById(id); }
    public List<Contrat> addContrats(List<Contrat> contrats) { return contratRepository.saveAll(contrats); }
}
