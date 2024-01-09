package tn.esprit.se.clinique.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.se.clinique.entity.Clinique;
@Repository
public interface CliniqueRepository extends JpaRepository<Clinique,Long> {
}
