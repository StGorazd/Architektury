package bednarhalaj.repository;

import bednarhalaj.mapper.TeamRowMapper;
import bednarhalaj.domain.Team;
import bednarhalaj.request.UpdateTeamRequest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TeamRepository extends Repository {
    private final TeamRowMapper teamRowMapper = new TeamRowMapper();

    public TeamRepository() {
        super("src/main/resources/teamSchema.sql");
    }

    public Integer add(Team team) {
        final String sql = "INSERT INTO Teams(department_id, team_leader_id) VALUES (?, ?)";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, team.getDepartmentId());
            preparedStatement.setInt(2, team.getTeamLeaderId());
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

    public Team get(int id) {
        final String sql = "SELECT * FROM Teams WHERE id = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return teamRowMapper.mapRow(resultSet);
            } else {
                throw new SQLException("Selecting team failed, no team was selected.");
            }
        } catch (SQLException e) {
            return null;
        }

    }

    public List<Team> getAll() {
        final String sql = "SELECT * FROM Teams";
        final List<Team> teams = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                teams.add(teamRowMapper.mapRow(resultSet));
            }
        } catch (SQLException e) {
            return teams;
        }
        return teams;
    }

    public void delete(int id) {
        final String sql = "DELETE FROM Teams WHERE id = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Deleting team failed, no rows affected.");
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void update(int id, UpdateTeamRequest updateTeamRequest) {
        final String sql = "UPDATE Teams SET department_id = ?, team_leader_id = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, updateTeamRequest.getDepartmentId());
            preparedStatement.setInt(2, updateTeamRequest.getTeamLeaderId());
            preparedStatement.setInt(3, id);
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating team failed, no rows affected.");
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
