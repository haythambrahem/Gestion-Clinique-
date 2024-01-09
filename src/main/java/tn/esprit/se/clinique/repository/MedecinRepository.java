package tn.esprit.se.clinique.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.se.clinique.entity.Clinique;
import tn.esprit.se.clinique.entity.Medecin;

@Repository
public interface MedecinRepository extends JpaRepository<Medecin,Long> {
}
