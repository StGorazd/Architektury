package bednarhalaj.repository;

import bednarhalaj.mapper.EmployeeRowMapper;
import bednarhalaj.request.UpdateEmployeeRequest;
import bednarhalaj.domain.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository extends Repository {

    private final EmployeeRowMapper employeeRowMapper = new EmployeeRowMapper();

    public EmployeeRepository() {
        super("src/main/resources/employeeSchema.sql");
    }

    public Integer add(Employee employee) {
        final String sql = "INSERT INTO Employees(age, address, employee_since, email, first_name, surname, team_id, position, salary_bonus) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, employee.getAge());
            preparedStatement.setString(2, employee.getAddress());
            preparedStatement.setObject(3, employee.getEmployeeSince());
            preparedStatement.setString(4, employee.getEmail());
            preparedStatement.setString(5, employee.getFirstname());
            preparedStatement.setString(6, employee.getSurname());
            preparedStatement.setInt(7, employee.getTeamId());
            preparedStatement.setInt(8, employee.getPosition());
            preparedStatement.setBigDecimal(9, employee.getSalaryBonus());
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                return null;
            }
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    return null;
                }
            }

        } catch (SQLException e) {
            return null;
        }

    }

    public Employee get(int id) {
        final String sql = "SELECT * FROM Employees WHERE id = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return employeeRowMapper.mapRow(resultSet);
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Employee> getAll() {
        final String sql = "SELECT * FROM Employees";
        final List<Employee> employees = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employees.add(employeeRowMapper.mapRow(resultSet));
            }
        } catch (SQLException e) {
            return employees;
        }
        return employees;
    }

    public void delete(int id) {
        final String sql = "DELETE FROM Employees WHERE id = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Deleting employee failed, no rows affected.");
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void update(int id, UpdateEmployeeRequest updateEmployeeRequest) {
        final String sql = "UPDATE Employees SET age = ?, address = ?, employee_since = ?, email = ?, first_name = ?, surname = ?, team_id = ?, position = ?, salary_bonus = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, updateEmployeeRequest.getAge());
            preparedStatement.setString(2, updateEmployeeRequest.getAddress());
            preparedStatement.setObject(3, updateEmployeeRequest.getEmployeeSince());
            preparedStatement.setString(4, updateEmployeeRequest.getEmail());
            preparedStatement.setString(5, updateEmployeeRequest.getFirstname());
            preparedStatement.setString(6, updateEmployeeRequest.getSurname());
            preparedStatement.setInt(7, updateEmployeeRequest.getTeamId());
            preparedStatement.setInt(8, updateEmployeeRequest.getPosition());
            preparedStatement.setBigDecimal(9, updateEmployeeRequest.getSalaryBonus());
            preparedStatement.setInt(10, id);
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating employee failed, no rows affected.");
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
