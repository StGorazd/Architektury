package bednarhalaj.command.crud.read;

import bednarhalaj.model.hierarchy.Team;
import bednarhalaj.repository.impl.TeamRepository;
import bednarhalaj.repository.impl.proxy.SecuredRepository;

import java.util.ArrayList;
import java.util.List;

public class ReadAllTeamsCommand extends ReadAllCommand<Team> {
    @Override
    public List<Team> execute() {
        TeamRepository teamRepository = new TeamRepository(entityManager);
        SecuredRepository<Team> repository = new SecuredRepository<>(teamRepository);
        try {
            return repository.readAll();
        } catch (IllegalAccessException e) {
            System.out.println("\nAccess denied!\n");
        }
        return new ArrayList<>();
    }
}
