package bednarhalaj.mapper;

import bednarhalaj.domain.Position;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PositionRowMapper {

    public Position mapRow(ResultSet rs) throws SQLException {
        Position position = new Position();
        position.setId(rs.getInt("id"));
        position.setDepartmentId(rs.getInt("department_id"));
        position.setName(rs.getString("name"));
        position.setBaseSalary(rs.getBigDecimal("base_salary"));
        return position;
    }
}
