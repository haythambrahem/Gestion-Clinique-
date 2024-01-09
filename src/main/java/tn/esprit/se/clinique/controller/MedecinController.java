package tn.esprit.se.clinique.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.se.clinique.entity.Medecin;
import tn.esprit.se.clinique.service.MedecinService;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class MedecinController {
    @Autowired
    MedecinService medecinService;
    @PostMapping("/ajouterMedcin")
    @ResponseBody
    public Medecin ajouterMedecin(@RequestBody Medecin M){
        medecinService.ajouterMedecin(M);
        return M;
    }

    @PutMapping(value = "/affecterMedecinActionnaireAClinique/{medecinId}/{cliniqueId}")
    @ResponseBody
    public void affecterMedecinAClinique(@PathVariable("medecinId")int medecinId, @PathVariable("cliniqueId")int cliniqueId) {
        medecinService.affecterMedecinActionnaireAClinique(medecinId, cliniqueId);
    }

    // http://localhost:8081/gestionClinique/affecterMedecinOrdinaireAClinique/1/1
    @PutMapping(value = "/affecterMedecinOrdinaireAClinique/{medecinId}/{cliniqueId}")
    @ResponseBody
    public void affecterMedecinOrdinaireAClinique(@PathVariable("medecinId")int medecinId, @PathVariable("cliniqueId")int cliniqueId) {
        medecinService.affecterMedecinOrdinaireAClinique(medecinId, cliniqueId);

    }
}
