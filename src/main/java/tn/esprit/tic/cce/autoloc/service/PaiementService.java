package tn.esprit.tic.cce.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tic.cce.autoloc.domain.Paiement;
import tn.esprit.tic.cce.autoloc.repository.PaiementRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaiementService implements IPaiementService {
    private final PaiementRepository paiementRepository;
    public List<Paiement> retrieveAllPaiements() { return paiementRepository.findAll(); }
    public Paiement addPaiement(Paiement paiement) { return paiementRepository.save(paiement); }
    public Paiement updatePaiement(Paiement paiement) { return paiementRepository.save(paiement); }
    public Paiement retrievePaiement(Long id) { return paiementRepository.findById(id).orElse(null); }
    public void removePaiement(Long id) { paiementRepository.deleteById(id); }
    public List<Paiement> addPaiements(List<Paiement> paiements) { return paiementRepository.saveAll(paiements); }
}
