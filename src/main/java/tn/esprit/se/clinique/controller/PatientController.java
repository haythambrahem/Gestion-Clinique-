package tn.esprit.se.clinique.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.se.clinique.entity.Patient;
import tn.esprit.se.clinique.service.PatientService;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class PatientController {
    @Autowired
    PatientService patientService;
    @PostMapping("/ajouterPatientEtAffecterAuMedecin/{idMedecin}")
    public Patient ajouterPatientEtAffecterAuMedecin(@RequestBody Patient patient,
                                                     @PathVariable("idMedecin") Long idMedecin)
    {
        patientService.ajouterPatientEtAffecterAuMedecin(patient,idMedecin);
        return patient;
    }
}
