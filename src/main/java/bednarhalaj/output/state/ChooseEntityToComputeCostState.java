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
            ReadAllCommand<Employee> readAllCommand = new ReadAllEmployeesCommand();
            List<Employee> employeeList = readAllCommand.execute();
            if (!employeeList.isEmpty()) {
                nextState = ComputeCostState.getInstance();
                outputStrategyToReturn = new ListHierarchyEntityOutputStrategy(employeeList, true);
            }
        } else if (menuItem == EntityMenuItem.TEAM) {
            ReadAllCommand<Team> readAllCommand = new ReadAllTeamsCommand();
            List<Team> teamList = readAllCommand.execute();
            if (!teamList.isEmpty()) {
                nextState = ComputeCostState.getInstance();
                outputStrategyToReturn = new ListHierarchyEntityOutputStrategy(teamList, true);
            }
        } else if (menuItem == EntityMenuItem.DEPARTMENT) {
            ReadAllCommand<Department> readAllCommand = new ReadAllDepartmentsCommand();
            List<Department> departments = readAllCommand.execute();
            if (!departments.isEmpty()) {
                nextState = ComputeCostState.getInstance();
                outputStrategyToReturn = new ListHierarchyEntityOutputStrategy(departments, true);
            }

        } else if (menuItem == EntityMenuItem.COMPANY) {
            ReadAllCommand<Company> readAllCommand = new ReadAllCompaniesCommand();
            List<Company> companies = readAllCommand.execute();
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
