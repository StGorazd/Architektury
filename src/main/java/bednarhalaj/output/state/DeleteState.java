package bednarhalaj.output.state;

import bednarhalaj.command.Command;
import bednarhalaj.command.crud.delete.*;
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

public class DeleteState extends State {

    private static DeleteState deleteStateInstance = null;

    private DeleteState(){

    }

    public static DeleteState getInstance(){
        if (deleteStateInstance == null){
            deleteStateInstance = new DeleteState();
        }

        return deleteStateInstance;
    }

    @Override
    public Component operation(MenuItem<?> menuItem) {
        State nextState = ChooseActionState.getInstance();
        Component componentToReturn = getFirstComponent();
        try {
            if (menuItem == DBEntityMenuItem.ITEM) {
                DBEntityMenuItem localMenuItem = (DBEntityMenuItem) menuItem;
                DBEntity item = localMenuItem.getLabel();
                if (item instanceof Employee) {
                    Command<Void> deleteEmployeeCommand = new DeleteEmployeeCommand((Employee) localMenuItem.getLabel());
                    deleteEmployeeCommand.execute();
                } else if (item instanceof Team) {
                    Command<Void> deleteTeamCommand = new DeleteTeamCommand((Team) localMenuItem.getLabel());
                    deleteTeamCommand.execute();
                } else if (item instanceof Department) {
                    Command<Void> deleteDepartmentCommand = new DeleteDepartmentCommand((Department) localMenuItem.getLabel());
                    deleteDepartmentCommand.execute();
                } else if (item instanceof Company) {
                    Command<Void> deleteCompanyCommand = new DeleteCompanyCommand((Company) localMenuItem.getLabel());
                    deleteCompanyCommand.execute();
                } else if (item instanceof Position) {
                    Command<Void> deletePositionCommand = new DeletePositionCommand((Position) localMenuItem.getLabel());
                    deletePositionCommand.execute();
                }
            }
        } catch (Exception e) {
            System.out.println("Something went wrong when deleting an entry");
        }
        nextState.setOutputMediator(outputMediator);
        outputMediator.setActualState(nextState);
        return componentToReturn;
    }
}
