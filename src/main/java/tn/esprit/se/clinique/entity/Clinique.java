package tn.esprit.se.clinique.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Clinique implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String designation;
    private String adresse;

    @OneToOne
    private Medecin medecin;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliniques")
    private Set<Medecin> medecins;
}
