package bednarhalaj.output.state;

import bednarhalaj.command.crud.create.*;
import bednarhalaj.model.Position;
import bednarhalaj.model.hierarchy.Company;
import bednarhalaj.model.hierarchy.Department;
import bednarhalaj.model.hierarchy.Employee;
import bednarhalaj.model.hierarchy.Team;
import bednarhalaj.output.items.EntityMenuItem;
import bednarhalaj.output.items.MenuItem;
import bednarhalaj.output.strategy.OutputStrategy;

public class ChooseEntityToCreateState extends State {
    private static ChooseEntityToCreateState chooseEntityToCreateStateInstance = null;

    private ChooseEntityToCreateState(){

    }

    public static ChooseEntityToCreateState getInstance(){
        if (chooseEntityToCreateStateInstance == null){
            chooseEntityToCreateStateInstance = new ChooseEntityToCreateState();
        }

        return chooseEntityToCreateStateInstance;
    }
    @Override
    public OutputStrategy operation(MenuItem<?> menuItem) {
        State nextState = ChooseActionState.getInstance();
        OutputStrategy outputStrategyToReturn = getFirstOutputStrategy();
        try {
            if (menuItem == EntityMenuItem.EMPLOYEE) {
                CreateCommand<Employee> createCommand = new CreateEmployeeCommand(new Employee());
                createCommand.execute();
            } else if (menuItem == EntityMenuItem.TEAM) {
                CreateCommand<Team> createCommand = new CreateTeamCommand(new Team());
                createCommand.execute();
            } else if (menuItem == EntityMenuItem.DEPARTMENT) {
                CreateCommand<Department> createCommand = new CreateDepartmentCommand(new Department());
                createCommand.execute();
            } else if (menuItem == EntityMenuItem.COMPANY) {
                CreateCommand<Company> createCommand = new CreateCompanyCommand(new Company());
                createCommand.execute();
            } else if (menuItem == EntityMenuItem.POSITION) {
                CreateCommand<Position> createCommand = new CreatePositionCommand(new Position());
                createCommand.execute();
            }

        } catch (Exception e) {
            System.out.println("Something went wrong when creating an entry");
        }

        nextState.setOutputMediator(outputMediator);
        outputMediator.setActualState(nextState);
        return outputStrategyToReturn;
    }
}
