package bednarhalaj.command.crud.update;

import bednarhalaj.model.Position;

public class UpdatePositionCommand extends UpdateCommand<Position> {
    public UpdatePositionCommand(Position entity) {
        super(entity);
    }

    @Override
    public Void execute() {
        entity.accept(visitor);
        return null;
    }
}
