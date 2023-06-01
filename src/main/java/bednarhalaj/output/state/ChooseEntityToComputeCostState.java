package bednarhalaj.output.state;

import bednarhalaj.command.crud.read.*;
import bednarhalaj.model.hierarchy.Company;
import bednarhalaj.model.hierarchy.Department;
import bednarhalaj.model.hierarchy.Employee;
import bednarhalaj.model.hierarchy.Team;
import bednarhalaj.output.items.EntityMenuItem;
import bednarhalaj.output.items.MenuItem;
import bednarhalaj.output.strategy.ListHierarchyEntityOutputStrategy;
import bednarhalaj.output.strategy.OutputStrategy;

import java.util.List;

public class ChooseEntityToComputeCostState extends State {

    private static ChooseEntityToComputeCostState chooseEntityToComputeCostStateInstance = null;

    public static ChooseEntityToComputeCostState getInstance() {
        if (chooseEntityToComputeCostStateInstance == null) {
            chooseEntityToComputeCostStateInstance = new ChooseEntityToComputeCostState();
        }
        return chooseEntityToComputeCostStateInstance;
    }

    @Override
    public OutputStrategy operation(MenuItem<?> menuItem) {
        State nextState = ChooseActionState.getInstance();
        OutputStrategy outputStrategyToReturn = getFirstOutputStrategy();

        if (menuItem == EntityMenuItem.EMPLOYEE) {
            ReadCommand<Employee> readCommand = new ReadAllEmployeesCommand();
            List<Employee> employeeList = readCommand.execute();
            if (!employeeList.isEmpty()) {
                nextState = ComputeCostState.getInstance();
                outputStrategyToReturn = new ListHierarchyEntityOutputStrategy(employeeList, true);
            }
        } else if (menuItem == EntityMenuItem.TEAM) {
            ReadCommand<Team> readCommand = new ReadAllTeamsCommand();
            List<Team> teamList = readCommand.execute();
            if (!teamList.isEmpty()) {
                nextState = ComputeCostState.getInstance();
                outputStrategyToReturn = new ListHierarchyEntityOutputStrategy(teamList, true);
            }
        } else if (menuItem == EntityMenuItem.DEPARTMENT) {
            ReadCommand<Department> readCommand = new ReadAllDepartmentsCommand();
            List<Department> departments = readCommand.execute();
            if (!departments.isEmpty()) {
                nextState = ComputeCostState.getInstance();
                outputStrategyToReturn = new ListHierarchyEntityOutputStrategy(departments, true);
            }

        } else if (menuItem == EntityMenuItem.COMPANY) {
            ReadCommand<Company> readCommand = new ReadAllCompaniesCommand();
            List<Company> companies = readCommand.execute();
            if (!companies.isEmpty()) {
                nextState = ComputeCostState.getInstance();
                outputStrategyToReturn = new ListHierarchyEntityOutputStrategy(companies, true);
            }
        }

        nextState.setOutputMediator(outputMediator);
        outputMediator.setActualState(nextState);
        return outputStrategyToReturn;
    }
}
