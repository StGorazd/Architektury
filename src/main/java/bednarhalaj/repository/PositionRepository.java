package bednarhalaj.repository;

import bednarhalaj.mapper.PositionRowMapper;
import bednarhalaj.request.UpdatePositionRequest;
import bednarhalaj.domain.Position;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PositionRepository extends Repository {
    private final PositionRowMapper positionRowMapper = new PositionRowMapper();

    public PositionRepository() {
        super("src/main/resources/positionSchema.sql");
    }

    public Integer add(Position position) {
        final String sql = "INSERT INTO Positions(name, department_id, base_salary) VALUES (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, position.getName());
            preparedStatement.setInt(2, position.getDepartmentId());
            preparedStatement.setBigDecimal(3, position.getBaseSalary());
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

    public Position get(int id) {
        final String sql = "SELECT * FROM Positions WHERE id = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return positionRowMapper.mapRow(resultSet);
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Position> getAll() {
        final String sql = "SELECT * FROM Positions";
        final List<Position> positions = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                positions.add(positionRowMapper.mapRow(resultSet));
            }
        } catch (SQLException e) {
            return positions;
        }
        return positions;
    }

    public void delete(int id) {
        final String sql = "DELETE FROM Positions WHERE id = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Deleting position failed, no rows affected.");
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void update(int id, UpdatePositionRequest updatePositionRequest) {
        final String sql = "UPDATE Positions SET name = ?, department_id = ?, base_salary = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, updatePositionRequest.getName());
            preparedStatement.setInt(2, updatePositionRequest.getDepartmentId());
            preparedStatement.setBigDecimal(3, updatePositionRequest.getBaseSalary());
            preparedStatement.setInt(4, id);
            int affectedRows = preparedStatement.executeUpdate();
            if(affectedRows == 0){
                throw new SQLException("Updating position failed, no rows affected.");
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
