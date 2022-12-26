package inventoryService.commands.controllers;

import com.example.examen_blanc.commonApi.commands.CreateCategorieCommand;
import com.example.examen_blanc.commonApi.commands.CreateProductCommand;
import com.example.examen_blanc.commonApi.commands.UpdateCategorieCommand;
import com.example.examen_blanc.commonApi.commands.UpdateProductCommand;
import com.example.examen_blanc.commonApi.dtos.CreateCategorieRequestDTO;
import com.example.examen_blanc.commonApi.dtos.CreateProductRequestDTO;
import com.example.examen_blanc.commonApi.dtos.UpdateCategorieRequestDTO;
import com.example.examen_blanc.commonApi.dtos.UpdateProductRequestDTO;
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
@RequestMapping("/product/commands")
@AllArgsConstructor
@CrossOrigin("*")
public class ProductCommandController {

    private CommandGateway commandGateway;
    private EventStore eventStore;

    @PostMapping("/createProduct")
    public CompletableFuture<String> createProduct(@RequestBody CreateProductRequestDTO request) {
        return commandGateway.send(new CreateProductCommand(UUID.randomUUID().toString(),
                request.getName(),
                request.getPrice(),
                request.getStock(),
                request.getState()));
    }

    @PutMapping("/updateProduct")
    public CompletableFuture<String> updateProduct(@RequestBody UpdateProductRequestDTO request) {
        return commandGateway.send(new UpdateProductCommand(request.getId(),
                request.getName(),
                request.getPrice(),
                request.getStock(),
                request.getState()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        ResponseEntity<String> entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return entity;
    }

    @GetMapping("/eventStore/{prodId}")
    public Stream getEventsForAccount(@PathVariable(value = "prodId") String prodId) {
        return eventStore.readEvents(prodId).asStream();
    }

}
