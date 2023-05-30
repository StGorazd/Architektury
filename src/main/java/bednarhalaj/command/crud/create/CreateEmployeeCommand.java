package bednarhalaj.command.crud.create;

import bednarhalaj.model.hierarchy.Employee;


public class CreateEmployeeCommand extends CreateCommand<Employee> {
    public CreateEmployeeCommand(Employee entity) {
        super(entity);
    }

    @Override
    public Void execute() {
        entity.accept(visitor);
        return null;
    }
}
