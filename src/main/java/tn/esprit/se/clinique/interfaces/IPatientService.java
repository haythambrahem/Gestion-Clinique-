package tn.esprit.se.clinique.interfaces;

import tn.esprit.se.clinique.entity.Patient;

public interface IPatientService {
    Long ajouterPatientEtAffecterAuMedecin(Patient patient, Long idMedecin);

}
