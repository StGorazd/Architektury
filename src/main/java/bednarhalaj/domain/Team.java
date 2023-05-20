package bednarhalaj.domain;

import lombok.*;
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Team extends DBEntity {
    @NonNull
    private Integer teamLeaderId;
    @NonNull
    private Integer departmentId;


}
