package orderService.commands.controllers;

import com.example.examen_blanc.commonApi.commands.CreateOrderLigneCommand;
import com.example.examen_blanc.commonApi.commands.UpdateOrderLigneCommand;
import com.example.examen_blanc.commonApi.dtos.CreateOrderLigneRequestDTO;
import com.example.examen_blanc.commonApi.dtos.UpdateOrderLignerequestDTO;
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
@RequestMapping("/orderligne/commands")
@AllArgsConstructor
@CrossOrigin("*")
public class OrderLigneCommandController {
    private final CommandGateway commandGateway;
    private final EventStore eventStore;

    @PostMapping("/create")
    public CompletableFuture<String> createOrderLigne(@RequestBody CreateOrderLigneRequestDTO createorderLigneRequestDTO) {
        return commandGateway.send(new CreateOrderLigneCommand(
                UUID.randomUUID().toString(),
                createorderLigneRequestDTO.getQuantity(),
                createorderLigneRequestDTO.getPrice(),
                createorderLigneRequestDTO.getRemise()
        ));
    }

    @PutMapping("/update")
    public CompletableFuture<String> updateOrderLigne(@RequestBody UpdateOrderLignerequestDTO updateOrderLigneRequestDTO) {
        return commandGateway.send(new UpdateOrderLigneCommand(
                updateOrderLigneRequestDTO.getId(),
                updateOrderLigneRequestDTO.getQuantity(),
                updateOrderLigneRequestDTO.getPrice(),
                updateOrderLigneRequestDTO.getRemise()
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
