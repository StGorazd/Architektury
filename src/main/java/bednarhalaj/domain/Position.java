package bednarhalaj.domain;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Position extends DBEntity {
    private Integer idPosition;
    @NonNull
    private String name;
    @NonNull
    private Integer departmentId;
    @NonNull
    private BigDecimal baseSalary;

    private Position(Builder builder) {
        this.idPosition = builder.idPosition;
        this.name = builder.name;
        this.departmentId = builder.departmentId;
        this.baseSalary = builder.baseSalary;
    }

    public static class Builder {
        private final String name;
        private Integer departmentId;
        private BigDecimal baseSalary;
        private Integer idPosition;
        public Builder(String name) {
            this.name = name;
        }

        public Builder departmentId(Integer departmentId){
            this.departmentId = departmentId;
            return this;
        }

        public Builder baseSalary(BigDecimal baseSalary){
            this.baseSalary = baseSalary;
            return this;
        }

        public Builder idPosition(Integer idPosition){
            this.idPosition = idPosition;
            return this;
        }

        public Position build(){
            return new Position(this);
        }
    }
}
