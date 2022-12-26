package orderService.queries.services;

import com.example.examen_blanc.commonApi.events.OrderLigneCreatedEvent;
import com.example.examen_blanc.commonApi.events.OrderLigneUpdatedEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import orderService.queries.entities.OrderLigne;
import orderService.queries.repositories.OrderLigneRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class OrderLigneServiceHandler {
    private OrderLigneRepository orderLigneRepository;

    @EventHandler
    public void on(OrderLigneCreatedEvent event){
        log.info("**************************");
        log.info("OrderLigneCreatedEvent received");
        OrderLigne order = new OrderLigne();
        order.setId(event.getId());
        order.setQuantity(event.getQuantity());
        order.setPrice(event.getPrice());
        order.setRemise(event.getRemise());
    }

    @EventHandler
    public void on(OrderLigneUpdatedEvent event){
        log.info("**************************");
        log.info("OrderLigneUpdatedEvent received");
        OrderLigne order = orderLigneRepository.findById(event.getId()).get();
        order.setQuantity(event.getQuantity());
        order.setPrice(event.getPrice());
        order.setRemise(event.getRemise());
    }
}
