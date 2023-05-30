package bednarhalaj.command.crud.update;

import bednarhalaj.model.hierarchy.Company;

public class UpdateCompanyCommand extends UpdateCommand<Company> {
    public UpdateCompanyCommand(Company entity) {
        super(entity);
    }

    @Override
    public Void execute() {
        entity.accept(visitor);
        return null;
    }
}
