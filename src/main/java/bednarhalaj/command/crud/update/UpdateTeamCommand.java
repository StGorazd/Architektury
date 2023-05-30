package bednarhalaj.command.crud.update;

import bednarhalaj.model.hierarchy.Team;

public class UpdateTeamCommand extends UpdateCommand<Team> {
    public UpdateTeamCommand(Team entity) {
        super(entity);
    }

    @Override
    public Void execute() {
        entity.accept(visitor);
        return null;
    }
}
