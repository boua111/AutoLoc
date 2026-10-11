package tn.esprit.tic.cce.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tic.cce.autoloc.domain.Employe;
import tn.esprit.tic.cce.autoloc.repository.EmployeRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeService implements IEmployeService {
    private final EmployeRepository employeRepository;
    public List<Employe> retrieveAllEmployes() { return employeRepository.findAll(); }
    public Employe addEmploye(Employe employe) { return employeRepository.save(employe); }
    public Employe updateEmploye(Employe employe) { return employeRepository.save(employe); }
    public Employe retrieveEmploye(Long id) { return employeRepository.findById(id).orElse(null); }
    public void removeEmploye(Long id) { employeRepository.deleteById(id); }
    public List<Employe> addEmployes(List<Employe> employes) { return employeRepository.saveAll(employes); }
}
