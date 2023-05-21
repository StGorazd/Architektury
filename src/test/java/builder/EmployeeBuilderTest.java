package builder;

import bednarhalaj.model.Position;
import bednarhalaj.model.hierarchy.Company;
import bednarhalaj.model.hierarchy.Department;
import bednarhalaj.model.hierarchy.Employee;
import bednarhalaj.model.hierarchy.Team;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmployeeBuilderTest {
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
        Employee employee = new Employee.Builder("Jozko", "Mrkvicka")
                .email("jozko@mrkvicka.com")
                .address("Slovakia")
                .birthdate(LocalDate.of(1999, 11, 5))
                .salaryBonus(BigDecimal.valueOf(500))
                .employeeSince(LocalDate.of(2020, 1, 8))
                .team(team)
                .position(position)
                .build();
        Assertions.assertEquals("Jozko", employee.getFirstname());
        Assertions.assertEquals("Mrkvicka", employee.getSurname());
        Assertions.assertEquals("jozko@mrkvicka.com", employee.getEmail());
        Assertions.assertEquals("Slovakia", employee.getAddress());
        Assertions.assertEquals(LocalDate.of(1999, 11, 5), employee.getBirthdate());
        Assertions.assertEquals(BigDecimal.valueOf(500), employee.getSalaryBonus());
        Assertions.assertEquals(LocalDate.of(2020, 1, 8), employee.getEmployeeSince());
        Assertions.assertEquals(team, employee.getTeam());
        Assertions.assertEquals(position, employee.getPosition());
    }
}
