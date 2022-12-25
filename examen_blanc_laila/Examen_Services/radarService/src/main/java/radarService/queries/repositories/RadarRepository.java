package radarService.queries.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import radarService.queries.entities.Radar;

public interface RadarRepository extends JpaRepository<Radar,String> {

}
