package bednarhalaj.command.crud.create;

import bednarhalaj.model.hierarchy.Department;

public class CreateDepartmentCommand extends CreateCommand<Department> {
    public CreateDepartmentCommand(Department entity) {
        super(entity);
    }

    @Override
    public Void execute() {
        entity.accept(visitor);
        return null;
    }
}
