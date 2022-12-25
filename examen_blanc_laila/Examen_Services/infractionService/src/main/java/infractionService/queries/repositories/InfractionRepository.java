package infractionService.queries.repositories;

import infractionService.queries.entities.Infraction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfractionRepository extends JpaRepository<Infraction,String> {

}
