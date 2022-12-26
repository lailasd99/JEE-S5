package inventoryService.queries.services;

import com.example.examen_blanc.commonApi.events.CategorieCreatedEvent;
import com.example.examen_blanc.commonApi.events.CategorieUpdatedEvent;
import com.example.examen_blanc.commonApi.events.ProductCreatedEvent;
import com.example.examen_blanc.commonApi.events.ProductUpdatedEvent;
import inventoryService.queries.entities.Categorie;
import inventoryService.queries.entities.Product;
import inventoryService.queries.repositories.CategorieRepository;
import inventoryService.queries.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class InventoryServiceHandler {
    private CategorieRepository catRepository;
    private ProductRepository prodRepository;

    @EventHandler
    public void on(CategorieCreatedEvent event){
        log.info("**************************");
        log.info("CategorieCreatedEvent received");
        catRepository.save(new Categorie(
                event.getId(),
                event.getName(),
                event.getDesc()));
    }

    @EventHandler
    public void on(CategorieUpdatedEvent event){
        log.info("**************************");
        log.info("CategorieUpdatedEvent received");
        Categorie categorie = catRepository.findById(event.getId()).get();
        categorie.setName(event.getName());
        categorie.setDesc(event.getDesc());
    }

    @EventHandler
    public void on(ProductCreatedEvent event){
        log.info("**************************");
        log.info("ProductCreatedEvent received");
        prodRepository.save(new Product(
                event.getId(),
                event.getName(),
                event.getPrice(),
                event.getStock(),
                event.getState()));
    }

    @EventHandler
    public void on(ProductUpdatedEvent event){
        log.info("**************************");
        log.info("ProductUpdatedEvent received");
        Product product = prodRepository.findById(event.getId()).get();
        product.setName(event.getName());
        product.setPrice(event.getPrice());
        product.setStock(event.getStock());
        product.setState(event.getState());
    }
}
