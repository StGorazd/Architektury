package bednarhalaj.model.hierarchy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@NoArgsConstructor(force = true)
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class Company extends CompositeHierarchyEntity {
    @Column(name = "name")
    private String name;

    private Company(Company.Builder builder) {
        this.name = builder.name;
    }

    public static class Builder {
        private final String name;

        public Builder(String name) {
            this.name = name;
        }

        public Company build() {
            return new Company(this);
        }
    }
}