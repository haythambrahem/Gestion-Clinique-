package tn.esprit.se.clinique.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Medecin implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idMed;
    private String nom;
    private String prenom;

    @Temporal(TemporalType.DATE)
    private Date dateEmbauche;

    private String email;
    private String pwd;
    @Enumerated(EnumType.STRING)
    private Specialite specialite;

    @Enumerated(EnumType.STRING)
    private Poste poste;

    @OneToOne(mappedBy = "medecin")
    private Clinique clinique;

    @ManyToOne
    private Clinique cliniques;

    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "medecins")
    private Set<Patient> patients;
}
