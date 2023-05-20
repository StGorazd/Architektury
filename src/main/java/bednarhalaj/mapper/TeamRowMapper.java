package bednarhalaj.mapper;

import bednarhalaj.domain.Team;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeamRowMapper {

    public Team mapRow(ResultSet rs) throws SQLException {
        Team team = new Team();
        team.setId(rs.getInt("id"));
        team.setDepartmentId(rs.getInt("department_id"));
        team.setTeamLeaderId(rs.getInt("team_leader_id"));
        return team;
    }
}
