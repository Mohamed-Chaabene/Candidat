package t.esprit.arctic.jobmatch.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import t.esprit.arctic.jobmatch.entity.Candidat;
import t.esprit.arctic.jobmatch.repository.CandidatRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidatService {

    private final CandidatRepository repository;

    public Candidat create(Candidat candidat) {
        return repository.save(candidat);
    }

    public List<Candidat> getAll() {
        return repository.findAll();
    }

    public Candidat getById(Long id) {
        return repository.findById(id).orElseThrow(() -> 
            new RuntimeException("Candidat not found with id: " + id));
    }

    public Candidat update(Long id, Candidat candidatDetails) {
        Candidat candidat = getById(id);
        candidat.setNom(candidatDetails.getNom());
        candidat.setPrenom(candidatDetails.getPrenom());
        candidat.setEmail(candidatDetails.getEmail());
        candidat.setTelephone(candidatDetails.getTelephone());
        candidat.setDescription(candidatDetails.getDescription());
        candidat.setCv(candidatDetails.getCv());
        candidat.setLienPortfolio(candidatDetails.getLienPortfolio());
        candidat.setNiveauEtude(candidatDetails.getNiveauEtude());
        candidat.setCompetences(candidatDetails.getCompetences());
        candidat.setLocalisation(candidatDetails.getLocalisation());
        return repository.save(candidat);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

