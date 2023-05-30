package bednarhalaj.model.hierarchy;

import bednarhalaj.visitor.crud.PromptVisitor;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor(force = true)
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Team extends CompositeHierarchyEntity {

    @NonNull
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "department_id"))
    private Department department;

    private Team(Builder builder) {
        this.department = builder.department;
    }

    public void accept(PromptVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Name = " + name + ", Department = " + ((department != null) ? department.getName() : "NOT SET");
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
