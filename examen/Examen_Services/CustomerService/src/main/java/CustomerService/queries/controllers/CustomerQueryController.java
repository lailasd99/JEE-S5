package CustomerService.queries.controllers;

import CustomerService.queries.entities.Customer;
import CustomerService.queries.repositories.CustomerRepository;
import com.example.examen_blanc.commonApi.query.GetAllCustomersQuery;
import com.example.examen_blanc.commonApi.query.GetCustomerById;
import lombok.AllArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/customer/queries")
@CrossOrigin("*")
public class CustomerQueryController {
    private QueryGateway queryGateway;
    private CustomerRepository customerRepository;

    @GetMapping("/allCustomers")
    public List<Customer> getAllProprietaires() {
        return queryGateway.query(new GetAllCustomersQuery(), ResponseTypes.multipleInstancesOf(Customer.class)).join();
    }

    @QueryHandler
    public List<Customer> on(GetAllCustomersQuery query) {
        return customerRepository.findAll();
    }

    @GetMapping("/getProprietaire/{id}")
    public Customer getProprietaire(@PathVariable String id) {
        return queryGateway.query(new GetCustomerById(id),ResponseTypes.instanceOf(Customer.class)).join();
    }

    @QueryHandler
    public Customer on(GetCustomerById query) {
        return customerRepository.findById(query.getId()).orElse(null);
    }
}
