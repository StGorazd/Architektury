package bednarhalaj.model.hierarchy;

import bednarhalaj.visitor.crud.PromptVisitor;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(force = true)
@EqualsAndHashCode(callSuper = true)
public class Department extends CompositeHierarchyEntity {
    @NonNull
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "company_id"))
    private Company company;

    private Department(Builder builder) {
        this.name = builder.name;
        this.company = builder.company;
    }

    public void accept(PromptVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Name = " + name + ", Company = " + ((company != null) ? company.getName() : "NOT SET");
    }

    public static class Builder {
        private final String name;
        private Company company;


        public Builder(String name) {
            this.name = name;
        }

        public Builder company(Company company) {
            this.company = company;
            return this;
        }

        public Department build() {
            return new Department(this);
        }

    }

}
