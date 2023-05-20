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
    private Integer id;
    @NonNull
    private String name;
    @NonNull
    private Integer departmentId;
    @NonNull
    private BigDecimal baseSalary;

}
