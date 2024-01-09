package tn.esprit.se.clinique.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.se.clinique.entity.Clinique;
import tn.esprit.se.clinique.interfaces.ICliniqueService;
import tn.esprit.se.clinique.service.CliniqueService;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class CliniqueController {
    @Autowired
    CliniqueService cliniqueService;

    @PostMapping("/ajouterClinique")
    @ResponseBody
    public Clinique AjouterClinique(@RequestBody Clinique C){
        cliniqueService.AjouterClinique(C);
        return C;
    }

    @GetMapping("/retrieve-all-clinique")
    @ResponseBody
    public Clinique findAllClinique() {
        Clinique clinique = cliniqueService.findAllClinique();
        return clinique;
    }

}
