package tn.esprit.se.clinique.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.se.clinique.entity.Clinique;
import tn.esprit.se.clinique.entity.Medecin;
import tn.esprit.se.clinique.entity.Patient;
import tn.esprit.se.clinique.entity.Poste;
import tn.esprit.se.clinique.interfaces.IPatientService;
import tn.esprit.se.clinique.repository.CliniqueRepository;
import tn.esprit.se.clinique.repository.MedecinRepository;
import tn.esprit.se.clinique.repository.PatientRepository;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
@NoArgsConstructor
public class PatientService implements IPatientService {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    MedecinRepository medecinRepository;
    @Autowired
    CliniqueRepository cliniqueRepository;
    @Override
    public Long ajouterPatientEtAffecterAuMedecin(Patient patient, Long idMedecin) {
        Patient p = patientRepository.save(patient);
        Medecin medecin =medecinRepository.findById(idMedecin).get();
        medecin.getPatients().add(p);
        medecinRepository.save(medecin);
        return patient.getId();
    }

    @Override
    public Long getNombrePatientsExaminesParMedecinPoste(Poste poste) {
        return patientRepository.getNombrePatientsExaminesParMedecinActionaire(poste);
    }

    @Override
    public List<Patient> getAllPatientsByClinique(Long cliniqueId) {
        Clinique cliniqueEntity = cliniqueRepository.findById(cliniqueId).get();

        return patientRepository.getAllPatientByClinique(cliniqueEntity);
    }
}
