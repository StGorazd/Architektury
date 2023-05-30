package bednarhalaj.command.crud.update;

import bednarhalaj.model.hierarchy.Employee;

public class UpdateEmployeeCommand extends UpdateCommand<Employee> {
    public UpdateEmployeeCommand(Employee entity) {
        super(entity);
    }

    @Override
    public Void execute() {
        entity.accept(visitor);
        return null;
    }
}
