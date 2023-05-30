package bednarhalaj.command.crud.delete;

import bednarhalaj.model.EntityManagerHolder;
import bednarhalaj.model.Position;
import bednarhalaj.repository.impl.PositionRepository;
import jakarta.persistence.EntityManager;

public class DeletePositionCommand extends DeleteCommand<Position> {
    public DeletePositionCommand(Position entity) {
        super(entity);
    }

    @Override
    public Void execute() {
        EntityManager entityManager = EntityManagerHolder.getEntityManager();
        PositionRepository positionRepository = new PositionRepository(entityManager);
        positionRepository.delete(entity);
        return null;
    }
}
