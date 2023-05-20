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
public class Employee extends DBEntity{
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
}
