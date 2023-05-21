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

    private Team(Builder builder){
        this.teamLeaderId = builder.teamLeaderId;
        this.departmentId = builder.departmentId;
    }

    public static class Builder{
        private final Integer teamLeaderId;
        private Integer departmentId;
        public Builder(Integer teamLeaderId){
            this.teamLeaderId = teamLeaderId;
        }

        public Builder departmentId(Integer departmentId){
            this.departmentId = departmentId;
            return this;
        }

        public Team build(){
            return new Team(this);
        }
    }
}
