package bednarhalaj.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
@Setter
@EqualsAndHashCode
public class UpdateDepartmentRequest {
    @NonNull
    private String name;
    @NonNull
    private Integer headOfDepartmentId;
}
