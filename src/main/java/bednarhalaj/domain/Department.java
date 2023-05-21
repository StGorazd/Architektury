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

    private Department(Builder builder){
        this.name = builder.name;
        this.headOfDepartmentId = builder.headOfDepartmentId;
    }

    public static class Builder {
        private final String name;
        private Integer headOfDepartmentId;
        public Builder(String name){
            this.name = name;
        }

        public Builder headOfDepartmentId(Integer headOfDepartmentId){
            this.headOfDepartmentId = headOfDepartmentId;
            return this;
        }

        public Department build(){
            return new Department(this);
        }

    }
}
