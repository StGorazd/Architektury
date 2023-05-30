package bednarhalaj.command.crud.create;

import bednarhalaj.model.hierarchy.Company;

public class CreateCompanyCommand extends CreateCommand<Company> {

    public CreateCompanyCommand(Company entity) {
        super(entity);
    }

    @Override
    public Void execute() {
        entity.accept(visitor);
        return null;
    }
}
