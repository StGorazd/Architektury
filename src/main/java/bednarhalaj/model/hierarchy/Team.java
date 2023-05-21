package bednarhalaj.model.hierarchy;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@NoArgsConstructor(force = true)
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Team extends CompositeHierarchyEntity {
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "department_id"))
    private Department department;

    private Team(Builder builder) {
        this.department = builder.department;
    }

    public static class Builder {
        private Department department;

        public Builder department(Department department) {
            this.department = department;
            return this;
        }

        public Team build() {
            return new Team(this);
        }
    }
}
