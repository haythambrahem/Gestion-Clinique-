package tn.esprit.se.clinique.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.se.clinique.entity.Medecin;
import tn.esprit.se.clinique.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

}
