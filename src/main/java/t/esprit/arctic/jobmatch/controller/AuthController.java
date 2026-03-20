package t.esprit.arctic.jobmatch.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import t.esprit.arctic.jobmatch.dto.LoginRequest;
import t.esprit.arctic.jobmatch.dto.RegisterRequest;
import t.esprit.arctic.jobmatch.entity.Utilisateur;
import t.esprit.arctic.jobmatch.security.JwtService;
import t.esprit.arctic.jobmatch.service.UtilisateurService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UtilisateurService service;
    private final AuthenticationManager authManager;
    private final JwtService jwtService;

    //  REGISTER
    @PostMapping("/register")
    public Utilisateur register(@RequestBody RegisterRequest request) {
        Utilisateur user = new Utilisateur();
        user.setNom(request.nom);
        user.setEmail(request.email);
        user.setMotDePasse(request.motDePasse);
        user.setRole(request.role);

        return service.register(user);
    }

    // LOGIN
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email,
                        request.motDePasse
                )
        );

        return jwtService.generateToken(request.email);
    }

    //  TEST ROLE (DEBUG)
    @GetMapping("/test-role")
    public String testRole(Authentication auth) {

        if (auth == null) {
            return "No authentication";
        }

        return auth.getAuthorities().toString();
    }
}