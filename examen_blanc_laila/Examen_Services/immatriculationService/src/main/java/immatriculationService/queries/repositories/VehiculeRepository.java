package immatriculationService.queries.repositories;


import immatriculationService.queries.entities.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculeRepository extends JpaRepository<Vehicule, String> {
}

