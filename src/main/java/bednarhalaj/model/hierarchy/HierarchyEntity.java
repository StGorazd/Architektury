package bednarhalaj.model.hierarchy;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public abstract class HierarchyEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    public abstract BigDecimal getCost();
}
