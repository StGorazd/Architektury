package bednarhalaj.command.crud.read;

import bednarhalaj.model.Position;
import bednarhalaj.repository.impl.PositionRepository;

import java.util.List;

public class ReadAllPositionsCommand extends ReadCommand<Position> {
    @Override
    public List<Position> execute() {
        PositionRepository positionRepository = new PositionRepository(entityManager);
        return positionRepository.readAll();
    }
}
