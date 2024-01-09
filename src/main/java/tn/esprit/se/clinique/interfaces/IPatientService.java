package tn.esprit.se.clinique.interfaces;

import tn.esprit.se.clinique.entity.Patient;
import tn.esprit.se.clinique.entity.Poste;

import java.util.List;

public interface IPatientService {
    Long ajouterPatientEtAffecterAuMedecin(Patient patient, Long idMedecin);
    Long getNombrePatientsExaminesParMedecinPoste(Poste poste);
    List<Patient> getAllPatientsByClinique(Long cliniqueId);

}
