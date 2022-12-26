package inventoryService.queries.repositories;

import inventoryService.queries.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie,String> {

}
