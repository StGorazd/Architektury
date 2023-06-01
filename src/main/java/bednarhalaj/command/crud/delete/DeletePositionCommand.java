package bednarhalaj.command.crud.delete;

import bednarhalaj.model.EntityManagerHolder;
import bednarhalaj.model.Position;
import bednarhalaj.model.hierarchy.Employee;
import bednarhalaj.repository.impl.PositionRepository;
import bednarhalaj.repository.impl.proxy.SecuredRepository;
import jakarta.persistence.EntityManager;

public class DeletePositionCommand extends DeleteCommand<Position> {
    public DeletePositionCommand(Position entity) {
        super(entity);
    }

    @Override
    public Void execute() {
        EntityManager entityManager = EntityManagerHolder.getEntityManager();
        PositionRepository positionRepository = new PositionRepository(entityManager);
        SecuredRepository<Position> repository = new SecuredRepository<>(positionRepository);
        try {
            repository.delete(entity);
        } catch (IllegalAccessException e) {
            System.out.println("\nAccess denied!\n");
        }
        return null;
    }
}
