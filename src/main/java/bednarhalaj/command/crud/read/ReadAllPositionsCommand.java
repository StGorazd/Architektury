package bednarhalaj.command.crud.read;

import bednarhalaj.model.Position;
import bednarhalaj.repository.impl.PositionRepository;
import bednarhalaj.repository.impl.proxy.SecuredRepository;

import java.util.ArrayList;
import java.util.List;

public class ReadAllPositionsCommand extends ReadAllCommand<Position> {
    @Override
    public List<Position> execute() {
        PositionRepository positionRepository = new PositionRepository(entityManager);
        SecuredRepository<Position> repository = new SecuredRepository<>(positionRepository);
        try {
            return repository.readAll();
        } catch (IllegalAccessException e) {
            System.out.println("\nAccess denied!\n");
        }
        return new ArrayList<>();
    }
}
