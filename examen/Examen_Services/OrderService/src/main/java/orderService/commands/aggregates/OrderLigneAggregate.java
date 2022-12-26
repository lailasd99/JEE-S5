package orderService.commands.aggregates;

import com.example.examen_blanc.commonApi.commands.CreateOrderLigneCommand;
import com.example.examen_blanc.commonApi.commands.UpdateOrderLigneCommand;
import com.example.examen_blanc.commonApi.events.OrderLigneCreatedEvent;
import com.example.examen_blanc.commonApi.events.OrderLigneUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;


@Aggregate
public class OrderLigneAggregate {
    @AggregateIdentifier
    private String id;
    private int quantity;
    private double price;
    private double remise;

    public OrderLigneAggregate() {
    }

    @CommandHandler
    public OrderLigneAggregate(CreateOrderLigneCommand command) {
        AggregateLifecycle.apply(new OrderLigneCreatedEvent(
                command.getId(),
                command.getQuantity(),
                command.getPrice(),
                command.getRemise()
        ));
    }

    @EventSourcingHandler
    public void on(OrderLigneCreatedEvent event) {
        this.id = event.getId();
        this.quantity = event.getQuantity();
        this.price = event.getPrice();
        this.remise = event.getRemise();
    }

    @CommandHandler
    public void handle(UpdateOrderLigneCommand command) {
        AggregateLifecycle.apply(new OrderLigneUpdatedEvent(
                command.getId(),
                command.getQuantity(),
                command.getPrice(),
                command.getRemise()
        ));
    }

    @EventSourcingHandler
    public void on(OrderLigneUpdatedEvent event) {
        this.id = event.getId();
        this.quantity = event.getQuantity();
        this.price = event.getPrice();
        this.remise = event.getRemise();
    }
}
