package tn.esprit.se.clinique.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.se.clinique.entity.Clinique;
import tn.esprit.se.clinique.entity.Medecin;
import tn.esprit.se.clinique.entity.Patient;
import tn.esprit.se.clinique.entity.Poste;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
    @Query("SELECT count(*) FROM Patient p join p.medecins m WHERE m.poste=:poste")
    Long getNombrePatientsExaminesParMedecinActionaire(Poste poste);

    @Query("Select "
            + "DISTINCT p from Patient p "
            + "join p.medecins med "
            + "join med.clinique cli "
            + "where cli=:clinique")
    public List<Patient> getAllPatientByClinique(@Param("clinique") Clinique clinique);

}
