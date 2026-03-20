package t.esprit.arctic.jobmatch.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.URL;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Candidat extends Utilisateur {

    @NotBlank(message = "Le prénom est requis")
    @Size(min = 2, max = 100, message = "Le prénom doit contenir entre 2 et 100 caractères")
    private String prenom;

    @NotBlank(message = "Le téléphone est requis")
    @Pattern(regexp = "^[0-9+\\-\\s()]+$", message = "Le téléphone n'est pas valide")
    private String telephone;

    @Size(max = 1000, message = "La description ne doit pas dépasser 1000 caractères")
    @Column(columnDefinition = "TEXT")
    private String description;

    private String cv;

    @URL(message = "Le lien portfolio doit être une URL valide")
    private String lienPortfolio;

    @NotBlank(message = "Le niveau d'étude est requis")
    private String niveauEtude;

    @ManyToMany
    @JoinTable(
        name = "candidat_competence",
        joinColumns = @JoinColumn(name = "candidat_id"),
        inverseJoinColumns = @JoinColumn(name = "competence_id")
    )
    private List<Competence> competences;

    @ManyToOne
    @JoinColumn(name = "localisation_id")
    private Localisation localisation;
}

