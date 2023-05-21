package bednarhalaj.model.hierarchy;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Entity
@NoArgsConstructor(force = true)
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public abstract class CompositeHierarchyEntity extends HierarchyEntity {

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "HierarchyRelationships",
            joinColumns = @JoinColumn(name = "id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "parent_id", referencedColumnName = "id"))
    protected List<HierarchyEntity> subordinates = new ArrayList<>();

    public void addSubordinate(HierarchyEntity entity) {
        this.subordinates.add(entity);
    }

    public void removeSubordinate(HierarchyEntity entity) {
        this.subordinates.remove(entity);
    }

    @Override
    public BigDecimal getCost() {
        BigDecimal totalCost = BigDecimal.ZERO;
        for (HierarchyEntity entity : subordinates) {
            totalCost = totalCost.add(entity.getCost());
        }
        return totalCost;
    }
}
