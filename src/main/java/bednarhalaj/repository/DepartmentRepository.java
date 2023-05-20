package bednarhalaj.repository;

import bednarhalaj.mapper.DepartmentRowMapper;
import bednarhalaj.request.UpdateDepartmentRequest;
import bednarhalaj.domain.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepository extends Repository {

    private final DepartmentRowMapper departmentRowMapper = new DepartmentRowMapper();

    public DepartmentRepository() {
        super("src/main/resources/departmentSchema.sql");
    }

    public Integer add(Department department) {
        final String sql = "INSERT INTO Departments(name, head_of_department_id) VALUES (?, ?)";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, department.getName());
            preparedStatement.setInt(2, department.getHeadOfDepartmentId());
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

    public Department get(int id) {
        final String sql = "SELECT * FROM Departments WHERE id = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return departmentRowMapper.mapRow(resultSet);
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Department> getAll() {
        final String sql = "SELECT * FROM Departments";
        final List<Department> departments = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                departments.add(departmentRowMapper.mapRow(resultSet));
            }
        } catch (SQLException e) {
            return departments;
        }
        return departments;
    }

    public void delete(int id) {
        final String sql = "DELETE FROM Departments WHERE id = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Deleting department failed, no rows affected.");
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void update(int id, UpdateDepartmentRequest updateDepartmentRequest) {
        final String sql = "UPDATE Departments SET name = ?, head_of_department_id = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, updateDepartmentRequest.getName());
            preparedStatement.setInt(2, updateDepartmentRequest.getHeadOfDepartmentId());
            preparedStatement.setInt(3, id);
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating department failed, no rows affected.");
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
