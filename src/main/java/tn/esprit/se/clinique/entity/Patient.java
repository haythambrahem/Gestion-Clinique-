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
public class Patient implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String designation;
    private String code;
    private String cin;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Medecin> medecins;


}
