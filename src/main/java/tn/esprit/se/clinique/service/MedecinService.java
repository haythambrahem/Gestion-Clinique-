package tn.esprit.se.clinique.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.se.clinique.entity.Clinique;
import tn.esprit.se.clinique.entity.Medecin;
import tn.esprit.se.clinique.entity.Specialite;
import tn.esprit.se.clinique.interfaces.IMedcinService;
import tn.esprit.se.clinique.repository.CliniqueRepository;
import tn.esprit.se.clinique.repository.MedecinRepository;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
@AllArgsConstructor
@NoArgsConstructor
public class MedecinService implements IMedcinService {
    @Autowired
    MedecinRepository medecinRepository;
    @Autowired
    CliniqueRepository cliniqueRepository;
    @Override
    public Long ajouterMedecin(Medecin M) {
        medecinRepository.save(M);
        return M.getIdMed();
    }
    @Transactional
    @Override
    public void affecterMedecinActionnaireAClinique(int medecinId, int cliniqueId) {
        Medecin medecinEntity = medecinRepository.findById((long) medecinId).get();
        Clinique cliniqueEntity = cliniqueRepository.findById((long) cliniqueId).get();
        cliniqueEntity.setMedecin(medecinEntity);
        cliniqueRepository.save(cliniqueEntity);
    }
    @Transactional
    @Override
    public void affecterMedecinOrdinaireAClinique(int medecinId, int cliniqueId) {
        Clinique cliniqueEntity = cliniqueRepository.findById((long) cliniqueId).get();
        Medecin medecinEntity = medecinRepository.findById((long) medecinId).get();

        cliniqueEntity.setMedecin(medecinEntity);
        cliniqueRepository.save(cliniqueEntity);
    }

    @Override
    public List<String> getCardiologueMedecinNames() {
        List<Medecin> medecins= (List<Medecin>) medecinRepository.findAll();
        List<String> medecinNames = new ArrayList<String>();
        for(Medecin medecin : medecins){
            {
                if(medecin.getSpecialite().equals(Specialite.Cardiologue))
                    medecinNames.add(medecin.getNom());
            }

        }
        return medecinNames;
    }
}



