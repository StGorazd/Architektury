package bednarhalaj.model.command;

import bednarhalaj.model.hierarchy.Employee;

public class DeleteEmployee implements EmployeeCommand {

    private Employee employee;

    public DeleteEmployee(Employee employee){
        this.employee = employee;
    }

    @Override
    public void execute() {
        // TODO
    }
}
