package bednarhalaj.command.crud.delete;

import bednarhalaj.model.EntityManagerHolder;
import bednarhalaj.model.hierarchy.Team;
import bednarhalaj.repository.impl.TeamRepository;
import bednarhalaj.repository.impl.proxy.SecuredRepository;
import jakarta.persistence.EntityManager;

public class DeleteTeamCommand extends DeleteCommand<Team> {
    public DeleteTeamCommand(Team entity) {
        super(entity);
    }

    @Override
    public Void execute() {
        EntityManager entityManager = EntityManagerHolder.getInstance();
        TeamRepository teamRepository = new TeamRepository(entityManager);
        SecuredRepository<Team> repository = new SecuredRepository<>(teamRepository);
        try {
            repository.delete(entity);
        } catch (IllegalAccessException e) {
            System.out.println("\nAccess denied!\n");
        }
        return null;
    }
}
