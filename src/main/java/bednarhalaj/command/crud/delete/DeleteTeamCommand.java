package bednarhalaj.command.crud.delete;

import bednarhalaj.model.EntityManagerHolder;
import bednarhalaj.model.hierarchy.Team;
import bednarhalaj.repository.impl.DepartmentRepository;
import bednarhalaj.repository.impl.TeamRepository;
import jakarta.persistence.EntityManager;

public class DeleteTeamCommand extends DeleteCommand<Team> {
    public DeleteTeamCommand(Team entity) {
        super(entity);
    }

    @Override
    public Void execute() {
        EntityManager entityManager = EntityManagerHolder.getEntityManager();
        TeamRepository teamRepository = new TeamRepository(entityManager);
        teamRepository.delete(entity);
        return null;
    }
}
