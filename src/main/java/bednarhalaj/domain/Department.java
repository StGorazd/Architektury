package bednarhalaj.domain;

import lombok.*;
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Department extends DBEntity {
    @NonNull
    private String name;
    @NonNull
    private Integer headOfDepartmentId;
}
