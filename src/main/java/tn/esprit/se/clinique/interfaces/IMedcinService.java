package tn.esprit.se.clinique.interfaces;

import tn.esprit.se.clinique.entity.Medecin;

import java.util.List;

public interface IMedcinService {
    Long ajouterMedecin(Medecin M);
    void affecterMedecinActionnaireAClinique(int medecinId, int cliniqueId);
    void affecterMedecinOrdinaireAClinique(int medecinId, int cliniqueId);
    List<String> getCardiologueMedecinNames();

}
