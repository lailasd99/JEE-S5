package CustomerService.queries.repositories;


import CustomerService.queries.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
