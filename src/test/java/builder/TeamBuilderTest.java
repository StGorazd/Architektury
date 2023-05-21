package builder;

import bednarhalaj.model.hierarchy.Company;
import bednarhalaj.model.hierarchy.Department;
import bednarhalaj.model.hierarchy.Team;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TeamBuilderTest {

    @Test
    public void teamBuild() {
        Team team = new Team.Builder()
                .department(
                        new Department.Builder("HR")
                                .company(
                                        new Company.Builder("Google")
                                                .build())
                                .build())
                .build();

        Assertions.assertEquals("Google", team.getDepartment().getCompany().getName());
        Assertions.assertEquals("HR", team.getDepartment().getName());
    }
}
