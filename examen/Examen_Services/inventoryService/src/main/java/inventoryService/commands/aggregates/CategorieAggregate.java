package inventoryService.commands.aggregates;

import com.example.examen_blanc.commonApi.commands.CreateCategorieCommand;
import com.example.examen_blanc.commonApi.commands.UpdateCategorieCommand;
import com.example.examen_blanc.commonApi.events.CategorieCreatedEvent;
import com.example.examen_blanc.commonApi.events.CategorieUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class CategorieAggregate {
    @AggregateIdentifier
    private String id;
    private String name;
    private String desc;

    public CategorieAggregate() {
    }

    @CommandHandler
    public CategorieAggregate(CreateCategorieCommand command) {
        AggregateLifecycle.apply(new CreateCategorieCommand(
                command.getId(),
                command.getName(),
                command.getDesc()
        ));
    }

    @EventSourcingHandler
    public void on(CategorieCreatedEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.desc = event.getDesc();
    }

    @CommandHandler
    public void handle(UpdateCategorieCommand command) {
        AggregateLifecycle.apply(new CategorieUpdatedEvent(
                command.getId(),
                command.getName(),
                command.getDesc()
        ));
    }

    @EventSourcingHandler
    public void on(CategorieUpdatedEvent event) {
        this.name = event.getName();
        this.desc= event.getDesc();
    }
}
