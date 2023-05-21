package bednarhalaj.domain;


import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Employee extends DBEntity {
    @NonNull
    private String firstname;
    @NonNull
    private String surname;
    @NonNull
    private String email;
    @NonNull
    private String address;
    @NonNull
    private Integer age;
    @NonNull
    private BigDecimal salaryBonus;
    @NonNull
    private LocalDate employeeSince;
    @NonNull
    private Integer teamId;
    @NonNull
    private Integer position;

    private Employee(Builder builder) {
        this.firstname = builder.firstname;
        this.surname = builder.surname;
        this.email = builder.email;
        this.address = builder.address;
        this.age = builder.age;
        this.salaryBonus = builder.salaryBonus;
        this.employeeSince = builder.employeeSince;
        this.teamId = builder.teamId;
        this.position = builder.position;
    }

    public static class Builder {
        private final String firstname;
        private final String surname;
        private String email;
        private String address;
        private Integer age;
        private BigDecimal salaryBonus;
        private LocalDate employeeSince;
        private Integer teamId;
        private Integer position;

        public Builder(String firstname, String surname) {
            this.firstname = firstname;
            this.surname = surname;
        }

        public Builder email(String email){
            this.email = email;
            return this;
        }

        public Builder address(String address){
            this.address = address;
            return this;
        }

        public Builder age(Integer age){
            this.age = age;
            return this;
        }

        public Builder salaryBonus(BigDecimal salaryBonus){
            this.salaryBonus = salaryBonus;
            return this;
        }

        public Builder employeeSince(LocalDate employeeSince){
            this.employeeSince = employeeSince;
            return this;
        }

        public Builder teamId(Integer teamId){
            this.teamId = teamId;
            return this;
        }

        public Builder position(Integer position){
            this.position = position;
            return this;
        }

        public Employee build(){
            return new Employee(this);
        }
    }
}
