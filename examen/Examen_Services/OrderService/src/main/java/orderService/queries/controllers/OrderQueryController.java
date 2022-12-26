package orderService.queries.controllers;

import lombok.AllArgsConstructor;
import orderService.queries.repositories.OrderLigneRepository;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderligne/queries")
@AllArgsConstructor
@CrossOrigin("*")
public class OrderQueryController {
    private QueryGateway queryGateway;
    private OrderLigneRepository orderLigneRepository;

}
