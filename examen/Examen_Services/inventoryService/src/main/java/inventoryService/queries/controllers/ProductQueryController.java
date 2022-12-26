package inventoryService.queries.controllers;

import com.example.examen_blanc.commonApi.query.GetAllProductsQuery;
import com.example.examen_blanc.commonApi.query.GetProductById;
import inventoryService.queries.entities.Product;
import inventoryService.queries.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product/queries")
@AllArgsConstructor
@CrossOrigin("*")
public class ProductQueryController {
    private QueryGateway queryGateway;
    private ProductRepository productRepository;

    @GetMapping("/getAllRadars")
    public List<Product> getAllProducts(){
        return queryGateway.query(new GetAllProductsQuery(),
                ResponseTypes.multipleInstancesOf(Product.class)).join();
    }

    @QueryHandler
    public List<Product> on(GetAllProductsQuery query){
        return productRepository.findAll();
    }

    @GetMapping("/getPoduct/{id}")
    public Product getProduct(@PathVariable String id){
        return queryGateway.query(new GetProductById(id),
                ResponseTypes.instanceOf(Product.class)).join();
    }

    @QueryHandler
    public Product on(GetProductById query){
        return productRepository.findById(query
                .getId()).get();
    }
}
