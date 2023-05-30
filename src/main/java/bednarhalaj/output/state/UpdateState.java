package bednarhalaj.output.state;

import bednarhalaj.command.Command;
import bednarhalaj.command.crud.update.*;
import bednarhalaj.model.DBEntity;
import bednarhalaj.model.Position;
import bednarhalaj.model.hierarchy.Company;
import bednarhalaj.model.hierarchy.Department;
import bednarhalaj.model.hierarchy.Employee;
import bednarhalaj.model.hierarchy.Team;
import bednarhalaj.output.Component;
import bednarhalaj.output.items.DBEntityMenuItem;
import bednarhalaj.output.items.MenuItem;

public class UpdateState extends State {

    @Override
    public Component operation(MenuItem<?> menuItem) {
        try {
            if (menuItem == DBEntityMenuItem.ITEM) {
                DBEntityMenuItem localMenuItem = (DBEntityMenuItem) menuItem;
                DBEntity item = localMenuItem.getLabel();
                if (item instanceof Employee) {
                    Command<Void> updateEmployeeCommand = new UpdateEmployeeCommand((Employee) localMenuItem.getLabel());
                    updateEmployeeCommand.execute();
                } else if (item instanceof Team) {
                    Command<Void> updateTeamCommand = new UpdateTeamCommand((Team) localMenuItem.getLabel());
                    updateTeamCommand.execute();
                } else if (item instanceof Department) {
                    Command<Void> updateDepartmentCommand = new UpdateDepartmentCommand((Department) localMenuItem.getLabel());
                    updateDepartmentCommand.execute();
                } else if (item instanceof Company) {
                    Command<Void> updateCompanyCommand = new UpdateCompanyCommand((Company) localMenuItem.getLabel());
                    updateCompanyCommand.execute();
                } else if (item instanceof Position) {
                    Command<Void> updatePositionCommand = new UpdatePositionCommand((Position) localMenuItem.getLabel());
                    updatePositionCommand.execute();
                }
            }
        } catch (Exception e) {
            System.out.println("Something went wrong when updating an entry");
        }
        State nextState = new ChooseActionState();
        Component componentToReturn = getFirstComponent();
        nextState.setOutputMediator(outputMediator);
        outputMediator.setActualState(nextState);
        return componentToReturn;
    }
}
