package bednarhalaj.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TeamTest {

    @Test
    public void teamBuild(){
        Team team = new Team.Builder(5)
                .departmentId(25)
                .build();

        Assertions.assertEquals(5, team.getTeamLeaderId());
        Assertions.assertEquals(25, team.getDepartmentId());
    }
}
