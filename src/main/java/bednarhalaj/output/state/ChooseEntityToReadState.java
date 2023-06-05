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
    public OutputStrategy operation(MenuItem<?> menuItem) {
        State nextState = ChooseActionState.getInstance();
        OutputStrategy outputStrategyToReturn = getFirstOutputStrategy();

        if (menuItem == EntityMenuItem.EMPLOYEE) {
            ReadAllCommand<Employee> readAllCommand = new ReadAllEmployeesCommand();
            List<Employee> employeeList = readAllCommand.execute();
            outputStrategyToReturn = new ListDBEntityOutputStrategy(employeeList, false, "");
        } else if (menuItem == EntityMenuItem.TEAM) {
            ReadAllCommand<Team> readAllCommand = new ReadAllTeamsCommand();
            List<Team> teamList = readAllCommand.execute();
            outputStrategyToReturn = new ListDBEntityOutputStrategy(teamList, false,"");
        } else if (menuItem == EntityMenuItem.DEPARTMENT) {
            ReadAllCommand<Department> readAllCommand = new ReadAllDepartmentsCommand();
            List<Department> departments = readAllCommand.execute();
            outputStrategyToReturn = new ListDBEntityOutputStrategy(departments, false, "");
        } else if (menuItem == EntityMenuItem.COMPANY) {
            ReadAllCommand<Company> readAllCommand = new ReadAllCompaniesCommand();
            List<Company> companies = readAllCommand.execute();
            outputStrategyToReturn = new ListDBEntityOutputStrategy(companies, false, "");
        } else if (menuItem == EntityMenuItem.POSITION) {
            ReadAllCommand<Position> readAllCommand = new ReadAllPositionsCommand();
            List<Position> positions = readAllCommand.execute();
            outputStrategyToReturn = new ListDBEntityOutputStrategy(positions, false, "");
        }

        nextState.setOutputMediator(outputMediator);
        outputMediator.setActualState(nextState);
        return outputStrategyToReturn;
    }
}
