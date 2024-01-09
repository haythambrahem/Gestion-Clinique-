package tn.esprit.se.clinique.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.se.clinique.entity.Patient;
import tn.esprit.se.clinique.entity.Poste;
import tn.esprit.se.clinique.service.PatientService;

import java.util.List;

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
    @GetMapping(value = "/getNombrePatientsExaminesParMedecinActionaire/{poste}")
    @ResponseBody
    public Long getNombrePatientsExaminesParMedecinActionaire(@PathVariable("poste") Poste poste) {

        return patientService.getNombrePatientsExaminesParMedecinPoste(poste);
    }
    @GetMapping(value = "/getAllPatientsByClinique/{cliniqueId}")
    @ResponseBody
    public List<Patient> getAllPatientsByClinique(@PathVariable("cliniqueId")Long cliniqueId) {

        return patientService.getAllPatientsByClinique(cliniqueId);
    }}
