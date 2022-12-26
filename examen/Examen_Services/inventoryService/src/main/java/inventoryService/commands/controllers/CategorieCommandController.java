package inventoryService.commands.controllers;

import com.example.examen_blanc.commonApi.commands.CreateCategorieCommand;
import com.example.examen_blanc.commonApi.commands.UpdateCategorieCommand;
import com.example.examen_blanc.commonApi.dtos.CreateCategorieRequestDTO;
import com.example.examen_blanc.commonApi.dtos.UpdateCategorieRequestDTO;
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
@RequestMapping("/categorie/commands")
@AllArgsConstructor
@CrossOrigin("*")
public class CategorieCommandController {

    private CommandGateway commandGateway;
    private EventStore eventStore;

    @PostMapping("/createCategorie")
    public CompletableFuture<String> createCategorie(@RequestBody CreateCategorieRequestDTO request) {
        return commandGateway.send(new CreateCategorieCommand(UUID.randomUUID().toString(),
                request.getName(),
                request.getDesc()));
    }

    @PutMapping("/updateCategorie")
    public CompletableFuture<String> updateCategorie(@RequestBody UpdateCategorieRequestDTO request) {
        return commandGateway.send(new UpdateCategorieCommand(request.getId(),
                request.getName(),
                request.getDesc()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        ResponseEntity<String> entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return entity;
    }

    @GetMapping("/eventStore/{catId}")
    public Stream getEventsForAccount(@PathVariable(value = "catId") String catId) {
        return eventStore.readEvents(catId).asStream();
    }

}
