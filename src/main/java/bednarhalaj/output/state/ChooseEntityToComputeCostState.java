package bednarhalaj.output.state;

import bednarhalaj.command.crud.read.*;
import bednarhalaj.model.hierarchy.Company;
import bednarhalaj.model.hierarchy.Department;
import bednarhalaj.model.hierarchy.Employee;
import bednarhalaj.model.hierarchy.Team;
import bednarhalaj.output.Component;
import bednarhalaj.output.items.EntityMenuItem;
import bednarhalaj.output.items.MenuItem;
import bednarhalaj.output.strategy.ListHierarchyEntityOutputStrategy;

import java.util.List;

public class ChooseEntityToComputeCostState extends State {

    private static ChooseEntityToComputeCostState chooseEntityToComputeCostStateInstance = null;

    private ChooseEntityToComputeCostState () {

    }

    public static ChooseEntityToComputeCostState getInstance(){
        if (chooseEntityToComputeCostStateInstance == null){
            chooseEntityToComputeCostStateInstance = new ChooseEntityToComputeCostState();
        }
        return chooseEntityToComputeCostStateInstance;
    }

    @Override
    public Component operation(MenuItem<?> menuItem) {
        State nextState = ComputeCostState.getInstance();
        Component componentToReturn = getFirstComponent();

        if (menuItem == EntityMenuItem.EMPLOYEE) {
            ReadCommand<Employee> readCommand = new ReadAllEmployeesCommand();
            List<Employee> employeeList = readCommand.execute();
            componentToReturn = new ListHierarchyEntityOutputStrategy(employeeList, true);
        } else if (menuItem == EntityMenuItem.TEAM) {
            ReadCommand<Team> readCommand = new ReadAllTeamsCommand();
            List<Team> teamList = readCommand.execute();
            componentToReturn = new ListHierarchyEntityOutputStrategy(teamList, true);
        } else if (menuItem == EntityMenuItem.DEPARTMENT) {
            ReadCommand<Department> readCommand = new ReadAllDepartmentsCommand();
            List<Department> departments = readCommand.execute();
            componentToReturn = new ListHierarchyEntityOutputStrategy(departments, true);
        } else if (menuItem == EntityMenuItem.COMPANY) {
            ReadCommand<Company> readCommand = new ReadAllCompaniesCommand();
            List<Company> companies = readCommand.execute();
            componentToReturn = new ListHierarchyEntityOutputStrategy(companies, true);
        } else {
            nextState = ChooseActionState.getInstance();
        }

        nextState.setOutputMediator(outputMediator);
        outputMediator.setActualState(nextState);
        return componentToReturn;
    }
}
