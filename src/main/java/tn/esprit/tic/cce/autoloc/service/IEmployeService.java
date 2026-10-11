package tn.esprit.tic.cce.autoloc.service;

import tn.esprit.tic.cce.autoloc.domain.Employe;
import java.util.List;

public interface IEmployeService {
    List<Employe> retrieveAllEmployes();
    Employe addEmploye(Employe employe);
    Employe updateEmploye(Employe employe);
    Employe retrieveEmploye(Long id);
    void removeEmploye(Long id);
    List<Employe> addEmployes(List<Employe> employes);
}
