package bednarhalaj.model.hierarchy;


import bednarhalaj.model.DBEntity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public abstract class HierarchyEntity extends DBEntity implements Serializable {
    public abstract BigDecimal getCost();

}
