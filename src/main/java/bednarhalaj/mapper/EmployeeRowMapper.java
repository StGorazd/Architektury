package bednarhalaj.mapper;

import bednarhalaj.domain.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class EmployeeRowMapper {

    public Employee mapRow(ResultSet rs) throws SQLException {
        Employee employee = new Employee();
        employee.setId(rs.getInt("id"));
        employee.setAge(rs.getInt("age"));
        employee.setAddress(rs.getString("address"));
        employee.setEmployeeSince(rs.getObject("employee_since", LocalDate.class));
        employee.setEmail(rs.getString("email"));
        employee.setFirstname(rs.getString("first_name"));
        employee.setSurname(rs.getString("surname"));
        employee.setTeamId(rs.getInt("team_id"));
        employee.setPosition(rs.getInt("position"));
        employee.setSalaryBonus(rs.getBigDecimal("salary_bonus"));
        return employee;
    }
}
