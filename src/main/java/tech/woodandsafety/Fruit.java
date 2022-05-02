package tech.woodandsafety;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import io.smallrye.mutiny.Uni;

import javax.persistence.*;
import java.util.List;

@Entity
@Cacheable
@NamedQueries({
        @NamedQuery(name = "Fruit.searchByName", query = "from Fruit where name like ?1"),
        @NamedQuery(name = "Fruit.getByName", query = "from Fruit where name = ?1")
})
public class Fruit extends PanacheEntity {

    @Column(length = 40, unique = true)
    public String name;

    public static Uni<List<Fruit>> searchByName(String nameSearch) {
        return list("#Fruit.searchByName", '%' + nameSearch + '%');
    }

    public static Uni<Fruit> getByName(String name) {
        return find("name", name).firstResult();
    }
}
