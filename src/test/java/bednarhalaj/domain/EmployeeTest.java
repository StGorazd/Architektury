package bednarhalaj.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.math.BigDecimal;
import java.time.LocalDate;

class EmployeeTest {
    @Test
    public void employeeBuild(){
        Employee employee = new Employee.Builder("Jozko", "Mrkvicka")
                .email("jozko@mrkvicka.com")
                .address("Slovakia")
                .age(35)
                .salaryBonus(BigDecimal.ZERO)
                .employeeSince(LocalDate.of(2020, 1, 8))
                .teamId(2)
                .position(152)
                .build();
        Assertions.assertEquals("Jozko", employee.getFirstname());
        Assertions.assertEquals("Mrkvicka", employee.getSurname());
        Assertions.assertEquals("jozko@mrkvicka.com", employee.getEmail());
        Assertions.assertEquals("Slovakia", employee.getAddress());
        Assertions.assertEquals(35, employee.getAge());
        Assertions.assertEquals(BigDecimal.ZERO, employee.getSalaryBonus());
        Assertions.assertEquals(LocalDate.of(2020, 1, 8), employee.getEmployeeSince());
        Assertions.assertEquals(2, employee.getTeamId());
        Assertions.assertEquals(152, employee.getPosition());
    }
}