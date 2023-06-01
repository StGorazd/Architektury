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

public class ChooseEntityToDeleteState extends State {

    private static ChooseEntityToDeleteState chooseEntityToDeleteStateInstance = null;

    private ChooseEntityToDeleteState() {

    }

    public static ChooseEntityToDeleteState getInstance() {
        if (chooseEntityToDeleteStateInstance == null) {
            chooseEntityToDeleteStateInstance = new ChooseEntityToDeleteState();
        }

        return chooseEntityToDeleteStateInstance;
    }

    @Override
    public OutputStrategy operation(MenuItem<?> menuItem) {
        State nextState = ChooseActionState.getInstance();
        OutputStrategy outputStrategyToReturn = getFirstOutputStrategy();

        if (menuItem == EntityMenuItem.EMPLOYEE) {
            ReadCommand<Employee> readCommand = new ReadAllEmployeesCommand();
            List<Employee> employeeList = readCommand.execute();
            if (!employeeList.isEmpty()) {
                nextState = DeleteState.getInstance();
                outputStrategyToReturn = new ListDBEntityOutputStrategy(employeeList, true, "Select employee to delete:");
            }

        } else if (menuItem == EntityMenuItem.TEAM) {
            ReadCommand<Team> readCommand = new ReadAllTeamsCommand();
            List<Team> teamList = readCommand.execute();
            if (!teamList.isEmpty()) {
                nextState = DeleteState.getInstance();
                outputStrategyToReturn = new ListDBEntityOutputStrategy(teamList, true, "Select employee to delete:");
            }
        } else if (menuItem == EntityMenuItem.DEPARTMENT) {
            ReadCommand<Department> readCommand = new ReadAllDepartmentsCommand();
            List<Department> departments = readCommand.execute();
            if (!departments.isEmpty()) {
                nextState = DeleteState.getInstance();
                outputStrategyToReturn = new ListDBEntityOutputStrategy(departments, true, "Select employee to delete:");
            }
        } else if (menuItem == EntityMenuItem.COMPANY) {
            ReadCommand<Company> readCommand = new ReadAllCompaniesCommand();
            List<Company> companies = readCommand.execute();
            if (!companies.isEmpty()) {
                nextState = DeleteState.getInstance();
                outputStrategyToReturn = new ListDBEntityOutputStrategy(companies, true, "Select employee to delete:");
            }
        } else if (menuItem == EntityMenuItem.POSITION) {
            ReadCommand<Position> readCommand = new ReadAllPositionsCommand();
            List<Position> positions = readCommand.execute();
            if (!positions.isEmpty()) {
                nextState = DeleteState.getInstance();
                outputStrategyToReturn = new ListDBEntityOutputStrategy(positions, true, "Select employee to delete:");
            }
        }

        nextState.setOutputMediator(outputMediator);
        outputMediator.setActualState(nextState);
        return outputStrategyToReturn;
    }
}
