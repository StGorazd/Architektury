package bednarhalaj.request;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor(force = true)
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class UpdateEmployeeRequest {
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
