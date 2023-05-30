package bednarhalaj.command.crud.update;

import bednarhalaj.model.hierarchy.Department;

public class UpdateDepartmentCommand extends UpdateCommand<Department> {
    public UpdateDepartmentCommand(Department entity) {
        super(entity);
    }

    @Override
    public Void execute() {
        entity.accept(visitor);
        return null;
    }
}
