package bednarhalaj.request;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor(force = true)
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class UpdatePositionRequest {
    @NonNull
    private String name;
    @NonNull
    private Integer departmentId;
    @NonNull
    private BigDecimal baseSalary;
}
