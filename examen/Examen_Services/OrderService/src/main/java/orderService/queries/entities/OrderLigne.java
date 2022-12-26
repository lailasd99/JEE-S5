package orderService.queries.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class OrderLigne {
    private String id;
    private int quantity;
    private double price;
    private double remise;
}
