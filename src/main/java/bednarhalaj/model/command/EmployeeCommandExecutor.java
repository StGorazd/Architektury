package bednarhalaj.model.command;

import java.util.ArrayList;
import java.util.List;

public class EmployeeCommandExecutor {
    private final List<EmployeeCommand> employeeCommands = new ArrayList<>();

    public void executeCommand (EmployeeCommand employeeCommand) {
        employeeCommands.add(employeeCommand);
        employeeCommand.execute();
    }

}
