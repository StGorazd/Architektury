package bednarhalaj.output.state;

import bednarhalaj.command.crud.read.*;
import bednarhalaj.model.Position;
import bednarhalaj.model.hierarchy.Company;
import bednarhalaj.model.hierarchy.Department;
import bednarhalaj.model.hierarchy.Employee;
import bednarhalaj.model.hierarchy.Team;
import bednarhalaj.output.items.EntityMenuItem;
import bednarhalaj.output.items.MenuItem;
import bednarhalaj.output.strategy.ListDBEntityOutputStrategy;
import bednarhalaj.output.strategy.OutputStrategy;

import java.util.List;

public class ChooseEntityToUpdateState extends State {
    private static ChooseEntityToUpdateState chooseEntityToUpdateStateInstance = null;

    private ChooseEntityToUpdateState() {

    }

    public static ChooseEntityToUpdateState getInstance() {
        if (chooseEntityToUpdateStateInstance == null) {
            chooseEntityToUpdateStateInstance = new ChooseEntityToUpdateState();
        }
        return chooseEntityToUpdateStateInstance;
    }

    @Override
    public OutputStrategy operation(MenuItem<?> menuItem) {
        State nextState = ChooseActionState.getInstance();
        OutputStrategy outputStrategyToReturn = getFirstOutputStrategy();

        if (menuItem == EntityMenuItem.EMPLOYEE) {
            ReadAllCommand<Employee> readAllCommand = new ReadAllEmployeesCommand();
            List<Employee> employeeList = readAllCommand.execute();
            if (!employeeList.isEmpty()) {
                nextState = UpdateState.getInstance();
                outputStrategyToReturn = new ListDBEntityOutputStrategy(employeeList, true, "Select employee to update:");
            }

        } else if (menuItem == EntityMenuItem.TEAM) {
            ReadAllCommand<Team> readAllCommand = new ReadAllTeamsCommand();
            List<Team> teamList = readAllCommand.execute();
            if (!teamList.isEmpty()) {
                nextState = UpdateState.getInstance();
                outputStrategyToReturn = new ListDBEntityOutputStrategy(teamList, true, "Select employee to update:");
            }

        } else if (menuItem == EntityMenuItem.DEPARTMENT) {
            ReadAllCommand<Department> readAllCommand = new ReadAllDepartmentsCommand();
            List<Department> departments = readAllCommand.execute();
            if (!departments.isEmpty()) {
                nextState = UpdateState.getInstance();
                outputStrategyToReturn = new ListDBEntityOutputStrategy(departments, true, "Select employee to update:");
            }

        } else if (menuItem == EntityMenuItem.COMPANY) {
            ReadAllCommand<Company> readAllCommand = new ReadAllCompaniesCommand();
            List<Company> companies = readAllCommand.execute();
            if (!companies.isEmpty()) {
                nextState = UpdateState.getInstance();
                outputStrategyToReturn = new ListDBEntityOutputStrategy(companies, true, "Select employee to update:");
            }

        } else if (menuItem == EntityMenuItem.POSITION) {
            ReadAllCommand<Position> readAllCommand = new ReadAllPositionsCommand();
            List<Position> positions = readAllCommand.execute();
            if (!positions.isEmpty()) {
                nextState = UpdateState.getInstance();
                outputStrategyToReturn = new ListDBEntityOutputStrategy(positions, true, "Select employee to update:");
            }
        }
        nextState.setOutputMediator(outputMediator);
        outputMediator.setActualState(nextState);
        return outputStrategyToReturn;
    }
}
