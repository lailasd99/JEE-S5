package CustomerService.queries.service;

import CustomerService.queries.entities.Customer;
import CustomerService.queries.repositories.CustomerRepository;
import com.example.examen_blanc.commonApi.events.CustomerCreatedEvent;
import com.example.examen_blanc.commonApi.events.CustomerUpdatedEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerServiceHandler {
    private final CustomerRepository customerRepository;

    @EventHandler
    public void on(CustomerCreatedEvent event) {
        log.info("*********************************");
        log.info("CustomerCreatedEvent  received");
        Customer customer = new Customer();
        customer.setId(event.getId());
        customer.setName(event.getName());
        customer.setAddress(event.getAddress());
        customer.setEmail(event.getEmail());
        customer.setPhone(event.getPhone());
        customerRepository.save(customer);
    }

    @EventHandler
    public void on(CustomerUpdatedEvent event) {
        log.info("*********************************");
        log.info("CustomerUpdatedEvent received");
        Customer customer = customerRepository.findById(event.getId()).get();
        customer.setName(event.getName());
        customer.setAddress(event.getAddress());
        customer.setEmail(event.getEmail());
        customer.setPhone(event.getPhone());
        customerRepository.save(customer);
    }

}
