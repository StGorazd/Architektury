package bednarhalaj.model.hierarchy;


import bednarhalaj.model.Position;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor(force = true)
@EqualsAndHashCode(callSuper = true)
public class Employee extends HierarchyEntity {
    @NonNull
    @Column(name = "first_name")
    private String firstname;

    @NonNull
    @Column(name = "surname")
    private String surname;

    @NonNull
    @Column(name = "email")
    private String email;

    @NonNull
    @Column(name = "address")
    private String address;

    @NonNull
    @Column(name = "birthdate")
    private LocalDate birthdate;

    @NonNull
    @Column(name = "salary_bonus")
    private BigDecimal salaryBonus;

    @NonNull
    @Column(name = "employee_since")
    private LocalDate employeeSince;

    @NonNull
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "team_id"))
    private Team team;

    @NonNull
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "position_id"))
    private Position position;

    @Override
    public BigDecimal getCost() {
        return position.getBaseSalary().add(salaryBonus);
    }

    private Employee(Builder builder) {
        this.firstname = builder.firstname;
        this.surname = builder.surname;
        this.email = builder.email;
        this.address = builder.address;
        this.birthdate = builder.birthdate;
        this.salaryBonus = builder.salaryBonus;
        this.employeeSince = builder.employeeSince;
        this.team = builder.team;
        this.position = builder.position;
    }

    public static class Builder {
        private final String firstname;
        private final String surname;
        private String email;
        private String address;
        private LocalDate birthdate;
        private BigDecimal salaryBonus;
        private LocalDate employeeSince;
        private Team team;
        private Position position;

        public Builder(String firstname, String surname) {
            this.firstname = firstname;
            this.surname = surname;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder birthdate(LocalDate birthdate) {
            this.birthdate = birthdate;
            return this;
        }

        public Builder salaryBonus(BigDecimal salaryBonus) {
            this.salaryBonus = salaryBonus;
            return this;
        }

        public Builder employeeSince(LocalDate employeeSince) {
            this.employeeSince = employeeSince;
            return this;
        }

        public Builder team(Team team) {
            this.team = team;
            return this;
        }

        public Builder position(Position position) {
            this.position = position;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}
