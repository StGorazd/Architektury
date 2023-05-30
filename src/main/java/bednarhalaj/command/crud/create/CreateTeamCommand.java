package bednarhalaj.command.crud.create;

import bednarhalaj.model.hierarchy.Team;

public class CreateTeamCommand extends CreateCommand<Team> {
    public CreateTeamCommand(Team entity) {
        super(entity);
    }

    @Override
    public Void execute() {
        entity.accept(visitor);
        return null;
    }
}
