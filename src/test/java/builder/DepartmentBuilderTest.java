package builder;

import bednarhalaj.model.hierarchy.Company;
import bednarhalaj.model.hierarchy.Department;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DepartmentBuilderTest {
    @Test
    public void departmentBuild() {
        Department department = new Department.Builder("accounting").company(new Company.Builder("Google").build()).build();
        Assertions.assertEquals("accounting", department.getName());
        Assertions.assertEquals("Google", department.getCompany().getName());
    }
}
