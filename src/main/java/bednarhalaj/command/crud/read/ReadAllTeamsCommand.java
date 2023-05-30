package bednarhalaj.command.crud.read;

import bednarhalaj.model.hierarchy.Team;
import bednarhalaj.repository.impl.TeamRepository;

import java.util.List;

public class ReadAllTeamsCommand extends ReadCommand<Team>{
    @Override
    public List<Team> execute() {
        TeamRepository teamRepository = new TeamRepository(entityManager);
        return teamRepository.readAll();
    }
}
