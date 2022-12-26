package inventoryService.queries.controllers;

import com.example.examen_blanc.commonApi.query.GetAllCategoriesQuery;
import com.example.examen_blanc.commonApi.query.GetCategorieById;
import inventoryService.queries.entities.Categorie;
import inventoryService.queries.entities.Product;
import inventoryService.queries.repositories.CategorieRepository;
import inventoryService.queries.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorie/queries")
@AllArgsConstructor
@CrossOrigin("*")
public class CategorieQueryController {
    private QueryGateway queryGateway;
    private CategorieRepository categorieRepository;

    @GetMapping("/getAllRadars")
    public List<Categorie> getAllCategories(){
        return queryGateway.query(new GetAllCategoriesQuery(),
                ResponseTypes.multipleInstancesOf(Categorie.class)).join();
    }

    @QueryHandler
    public List<Categorie> on(GetAllCategoriesQuery query){
        return categorieRepository.findAll();
    }

    @GetMapping("/getCat/{id}")
    public Categorie getCategorie(@PathVariable String id){
        return queryGateway.query(new GetCategorieById(id),
                ResponseTypes.instanceOf(Categorie.class)).join();
    }

    @QueryHandler
    public Categorie on(GetCategorieById query){
        return categorieRepository.findById(query
                .getId()).get();
    }
}
