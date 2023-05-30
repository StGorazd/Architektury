package bednarhalaj.model;

import bednarhalaj.model.hierarchy.Employee;
import bednarhalaj.visitor.crud.PromptVisitor;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(force = true)
@EqualsAndHashCode(callSuper = true)
public class Position extends DBEntity {

    @Column(name = "name")
    private String name;
    @Column(name = "base_salary")
    private BigDecimal baseSalary;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "PositionRelationships",
            joinColumns = @JoinColumn(name = "id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "position_id", referencedColumnName = "id"))
    private List<Employee> employees = new ArrayList<>();

    private Position(Builder builder) {
        this.name = builder.name;
        this.baseSalary = builder.baseSalary;
    }

    @Override
    public String toString() {
        return "Name = " + name + ", Base Salary = " + baseSalary.toString();
    }

    public void accept(PromptVisitor visitor) {
        visitor.visit(this);
    }

    public static class Builder {
        private final String name;
        private BigDecimal baseSalary;

        public Builder(String name) {
            this.name = name;
        }

        public Builder baseSalary(BigDecimal baseSalary) {
            this.baseSalary = baseSalary;
            return this;
        }

        public Position build() {
            return new Position(this);
        }
    }

}
