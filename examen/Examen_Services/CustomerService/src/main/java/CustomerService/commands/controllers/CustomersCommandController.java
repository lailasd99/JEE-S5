package CustomerService.commands.controllers;

import com.example.examen_blanc.commonApi.commands.CreateCustomerCommand;
import com.example.examen_blanc.commonApi.commands.UpdateCustomerCommand;
import com.example.examen_blanc.commonApi.dtos.CreateCustomerRequestDTO;
import com.example.examen_blanc.commonApi.dtos.UpdateCustomerRequestDTO;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
@CrossOrigin("*")
public class CustomersCommandController {
    private CommandGateway commandGateway;
    private EventStore eventStore;

    @PostMapping("/create")
    public CompletableFuture<String> createCustomer(@RequestBody CreateCustomerRequestDTO request) {
        return commandGateway.send(new CreateCustomerCommand(
                UUID.randomUUID().toString(),
                request.getName(),
                request.getAddress(),
                request.getEmail(),
                request.getPhone()
        ));
    }

    @PutMapping("/update")
    public CompletableFuture<String> updateCustomer(@RequestBody UpdateCustomerRequestDTO request) {
        return commandGateway.send(new UpdateCustomerCommand(
                request.getId(),
                request.getName(),
                request.getAddress(),
                request.getEmail(),
                request.getPhone()
        ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        ResponseEntity<String> entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return entity;
    }

    @GetMapping("/eventStore/{id}")
    public Stream getEventStore(@PathVariable String id) {
        return eventStore.readEvents(id).asStream();
    }

}
