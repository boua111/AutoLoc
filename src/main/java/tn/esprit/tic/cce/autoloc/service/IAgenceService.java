package tn.esprit.tic.cce.autoloc.service;

import tn.esprit.tic.cce.autoloc.domain.Agence;
import java.util.List;

public interface IAgenceService {
    List<Agence> retrieveAllAgences();
    Agence addAgence(Agence agence);
    Agence updateAgence(Agence agence);
    Agence retrieveAgence(Long id);
    void removeAgence(Long id);
    List<Agence> addAgences(List<Agence> agences);
}
