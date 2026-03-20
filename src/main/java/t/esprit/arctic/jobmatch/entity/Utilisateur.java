package t.esprit.arctic.jobmatch.entity;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Utilisateur {

        @Id
        @GeneratedValue
        private Long id;

        private String nom;

        @Column(unique = true)
        private String email;

        private String motDePasse;

        @Enumerated(EnumType.STRING)
        private Role role;
}