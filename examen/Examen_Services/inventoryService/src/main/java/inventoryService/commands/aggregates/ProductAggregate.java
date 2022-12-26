package inventoryService.commands.aggregates;

import com.example.examen_blanc.commonApi.commands.CreateProductCommand;
import com.example.examen_blanc.commonApi.commands.UpdateCustomerCommand;
import com.example.examen_blanc.commonApi.commands.UpdateProductCommand;
import com.example.examen_blanc.commonApi.enums.Etat;
import com.example.examen_blanc.commonApi.events.ProductCreatedEvent;
import com.example.examen_blanc.commonApi.events.ProductUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class ProductAggregate {
    @AggregateIdentifier
    private String id;
    private String name;
    private double price;
    private int stock;
    private Etat state;

    public ProductAggregate() {
    }

    @CommandHandler
    public ProductAggregate(CreateProductCommand command) {
        AggregateLifecycle.apply(new ProductCreatedEvent(
                command.getId(),
                command.getName(),
                command.getPrice(),
                command.getStock(),
                command.getState()
        ));
    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.price = event.getPrice();
        this.stock = event.getStock();
        this.state = event.getState();
    }

    @CommandHandler
    public void handle(UpdateProductCommand command) {
        AggregateLifecycle.apply(new ProductUpdatedEvent(
                command.getId(),
                command.getName(),
                command.getPrice(),
                command.getStock(),
                command.getState()
        ));
    }

    @EventSourcingHandler
    public void on(ProductUpdatedEvent event) {
        this.name = event.getName();
        this.price = event.getPrice();
        this.stock = event.getStock();
        this.state = event.getState();
    }
}
