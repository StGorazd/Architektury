package bednarhalaj.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DepartmentTest {
    @Test
    public void departmentBuild(){
        Department department = new Department.Builder("accounting")
                .headOfDepartmentId(25)
                .build();
        Assertions.assertEquals("accounting", department.getName());
        Assertions.assertEquals(25, department.getHeadOfDepartmentId());
    }
}
