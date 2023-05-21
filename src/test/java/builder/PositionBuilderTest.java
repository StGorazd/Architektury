package builder;

import bednarhalaj.model.Position;
import bednarhalaj.model.hierarchy.Company;
import bednarhalaj.model.hierarchy.Department;
import bednarhalaj.model.hierarchy.Team;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class PositionBuilderTest {

    @Test
    public void employeeBuild() {
        Team team = new Team.Builder()
                .department(
                        new Department.Builder("HR")
                                .company(
                                        new Company.Builder("Google")
                                                .build())
                                .build())
                .build();
        Position position = new Position.Builder("Software developer").baseSalary(BigDecimal.valueOf(5000)).build();
        Assertions.assertEquals("Software developer", position.getName());
        Assertions.assertEquals(BigDecimal.valueOf(5000), position.getBaseSalary());
    }
}
