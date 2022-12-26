package inventoryService.queries.entities;

import com.example.examen_blanc.commonApi.enums.Etat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Categorie {
    @Id
    private String id;
    private String name;
    private String desc;
}

