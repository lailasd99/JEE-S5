package immatriculationService.queries.repositories;


import immatriculationService.queries.entities.Proprietaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProprietaireRepository extends JpaRepository<Proprietaire, String> {
}
