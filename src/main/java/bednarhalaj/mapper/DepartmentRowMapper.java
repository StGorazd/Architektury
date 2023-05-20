package bednarhalaj.mapper;

import bednarhalaj.domain.Department;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentRowMapper {

    public Department mapRow(ResultSet rs) throws SQLException {
        Department department = new Department();
        department.setId(rs.getInt("id"));
        department.setName(rs.getString("name"));
        department.setHeadOfDepartmentId(rs.getInt("head_of_department_id"));
        return department;
    }
}
