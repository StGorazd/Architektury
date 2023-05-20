package bednarhalaj.request;

import lombok.*;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor(force = true)
@EqualsAndHashCode
public class UpdateTeamRequest {
    @NonNull
    private Integer teamLeaderId;
    @NonNull
    private Integer departmentId;
}
