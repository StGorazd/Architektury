package bednarhalaj.model.command;

import bednarhalaj.model.hierarchy.Employee;

public class AddEmployee implements EmployeeCommand {
    private Employee employee;

    public AddEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public void execute() {
        // TODO
    }
}
