package inventoryService.queries.repositories;

import inventoryService.queries.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,String> {

}
