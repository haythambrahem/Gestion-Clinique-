package tn.esprit.se.clinique.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.se.clinique.entity.Clinique;
import tn.esprit.se.clinique.interfaces.ICliniqueService;
import tn.esprit.se.clinique.repository.CliniqueRepository;
@Slf4j
@Service
@AllArgsConstructor
@NoArgsConstructor
public class CliniqueService implements ICliniqueService {
    @Autowired
    CliniqueRepository cliniqueRepository;
    @Override
    public Long AjouterClinique(Clinique C) {
        cliniqueRepository.save(C);
        return C.getId();
    }

    @Override
    public Clinique findAllClinique() {
        return (Clinique) cliniqueRepository.findAll();
    }
}
