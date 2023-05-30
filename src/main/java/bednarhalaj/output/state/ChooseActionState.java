package bednarhalaj.output.state;

import bednarhalaj.output.Component;
import bednarhalaj.output.items.EntityMenuItem;
import bednarhalaj.output.items.MenuItem;
import bednarhalaj.output.items.OperationMenuItem;
import bednarhalaj.output.strategy.ListItemsOutputStrategy;


public class ChooseActionState extends State {
    @Override
    public Component operation(MenuItem<?> menuItem) {
        State nextState = this;
        Component componentToReturn = getFirstComponent();
        if (menuItem == OperationMenuItem.CREATE) {
            nextState = new ChooseEntityToCreateState();
            componentToReturn = getNextComponentWithAllDBEntities();
        } else if (menuItem == OperationMenuItem.UPDATE) {
            nextState = new ChooseEntityToUpdateState();
            componentToReturn = getNextComponentWithAllDBEntities();
        } else if (menuItem == OperationMenuItem.DELETE) {
            nextState = new ChooseEntityToDeleteState();
            componentToReturn = getNextComponentWithAllDBEntities();
        } else if (menuItem == OperationMenuItem.READ) {
            nextState = new ChooseEntityToReadState();
            componentToReturn = getNextComponentWithAllDBEntities();
        } else if (menuItem == OperationMenuItem.COMPUTE_COST) {
            nextState = new ChooseEntityToComputeCostState();
            componentToReturn = getNextComponentWithHierarchyEntities();
        } else if (menuItem == OperationMenuItem.EXIT) {
            System.exit(0);
        }

        nextState.setOutputMediator(outputMediator);
        outputMediator.setActualState(nextState);
        return componentToReturn;
    }

    private Component getNextComponentWithAllDBEntities() {
        return new ListItemsOutputStrategy(EntityMenuItem.EMPLOYEE,
                EntityMenuItem.TEAM,
                EntityMenuItem.DEPARTMENT,
                EntityMenuItem.COMPANY,
                EntityMenuItem.POSITION,
                OperationMenuItem.BACK);
    }

    private Component getNextComponentWithHierarchyEntities() {
        return new ListItemsOutputStrategy(EntityMenuItem.EMPLOYEE,
                EntityMenuItem.TEAM,
                EntityMenuItem.DEPARTMENT,
                EntityMenuItem.COMPANY,
                OperationMenuItem.BACK);
    }
}
