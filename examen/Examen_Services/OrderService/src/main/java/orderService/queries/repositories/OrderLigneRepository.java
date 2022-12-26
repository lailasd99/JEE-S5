package orderService.queries.repositories;

import orderService.queries.entities.OrderLigne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLigneRepository extends JpaRepository<OrderLigne,String> {

}


