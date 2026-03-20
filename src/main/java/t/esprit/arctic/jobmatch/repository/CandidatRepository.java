package t.esprit.arctic.jobmatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import t.esprit.arctic.jobmatch.entity.Candidat;

@Repository
public interface CandidatRepository extends JpaRepository<Candidat, Long> {
}

