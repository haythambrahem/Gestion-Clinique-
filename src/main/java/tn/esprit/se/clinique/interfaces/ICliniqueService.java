package tn.esprit.se.clinique.interfaces;

import tn.esprit.se.clinique.entity.Clinique;

public interface ICliniqueService {
    Long AjouterClinique(Clinique C);
    Clinique findAllClinique ();
}
