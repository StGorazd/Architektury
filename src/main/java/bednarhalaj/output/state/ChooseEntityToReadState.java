package bednarhalaj.output.state;

import bednarhalaj.command.crud.read.*;
import bednarhalaj.model.Position;
import bednarhalaj.model.hierarchy.Company;
import bednarhalaj.model.hierarchy.Department;
import bednarhalaj.model.hierarchy.Employee;
import bednarhalaj.model.hierarchy.Team;
import bednarhalaj.output.Component;
import bednarhalaj.output.items.EntityMenuItem;
import bednarhalaj.output.items.MenuItem;
import bednarhalaj.output.strategy.ListDBEntityOutputStrategy;
import bednarhalaj.output.strategy.ListHierarchyEntityOutputStrategy;

import java.util.List;

public class ChooseEntityToReadState extends State{

    private static ChooseEntityToReadState chooseEntityToReadStateInstance = null;

    private ChooseEntityToReadState(){

    }

    public static ChooseEntityToReadState getInstance(){
        if (chooseEntityToReadStateInstance == null){
            chooseEntityToReadStateInstance = new ChooseEntityToReadState();
        }
        return chooseEntityToReadStateInstance;
    }

    @Override
    public Component operation(MenuItem<?> menuItem) {
        State nextState = ChooseActionState.getInstance();
        Component componentToReturn = getFirstComponent();

        if (menuItem == EntityMenuItem.EMPLOYEE) {
            ReadCommand<Employee> readCommand = new ReadAllEmployeesCommand();
            List<Employee> employeeList = readCommand.execute();
            componentToReturn = new ListDBEntityOutputStrategy(employeeList, false);
        } else if (menuItem == EntityMenuItem.TEAM) {
            ReadCommand<Team> readCommand = new ReadAllTeamsCommand();
            List<Team> teamList = readCommand.execute();
            componentToReturn = new ListDBEntityOutputStrategy(teamList, false);
        } else if (menuItem == EntityMenuItem.DEPARTMENT) {
            ReadCommand<Department> readCommand = new ReadAllDepartmentsCommand();
            List<Department> departments = readCommand.execute();
            componentToReturn = new ListDBEntityOutputStrategy(departments, false);
        } else if (menuItem == EntityMenuItem.COMPANY) {
            ReadCommand<Company> readCommand = new ReadAllCompaniesCommand();
            List<Company> companies = readCommand.execute();
            componentToReturn = new ListDBEntityOutputStrategy(companies, false);
        } else if (menuItem == EntityMenuItem.POSITION) {
            ReadCommand<Position> readCommand = new ReadAllPositionsCommand();
            List<Position> positions = readCommand.execute();
            componentToReturn = new ListDBEntityOutputStrategy(positions, false);
        }

        nextState.setOutputMediator(outputMediator);
        outputMediator.setActualState(nextState);
        return componentToReturn;
    }
}
