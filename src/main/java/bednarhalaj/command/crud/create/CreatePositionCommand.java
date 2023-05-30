package bednarhalaj.command.crud.create;

import bednarhalaj.model.Position;

public class CreatePositionCommand extends CreateCommand<Position> {
    public CreatePositionCommand(Position entity) {
        super(entity);
    }

    @Override
    public Void execute() {
        entity.accept(visitor);
        return null;
    }
}
