package CustomerService.commands.aggregates;

import com.example.examen_blanc.commonApi.commands.CreateCustomerCommand;
import com.example.examen_blanc.commonApi.commands.UpdateCustomerCommand;
import com.example.examen_blanc.commonApi.events.CustomerCreatedEvent;
import com.example.examen_blanc.commonApi.events.CustomerUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class CustomerAggregate {
    @AggregateIdentifier
    private String id;
    private String name;
    private String address;
    private String email;
    private String phone;

    public CustomerAggregate() {
    }

    @CommandHandler
    public CustomerAggregate(CreateCustomerCommand command) {
        AggregateLifecycle.apply(
                new CustomerCreatedEvent(
                        command.getId(),
                        command.getName(),
                        command.getAddress(),
                        command.getEmail(),
                        command.getPhone()
                )
        );
    }

    @EventSourcingHandler
    public void on(CustomerCreatedEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.address = event.getAddress();
        this.email = event.getEmail();
        this.phone = event.getPhone();
    }

    @CommandHandler
    public void handle(UpdateCustomerCommand command) {
        AggregateLifecycle.apply(
                new CustomerUpdatedEvent(
                        command.getId(),
                        command.getName(),
                        command.getAddress(),
                        command.getEmail(),
                        command.getPhone()
                )
        );
    }

    @EventSourcingHandler
    public void on(CustomerUpdatedEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.address = event.getAddress();
        this.email = event.getEmail();
        this.phone = event.getPhone();
    }
}
