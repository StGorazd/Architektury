package bednarhalaj.output.state;

import bednarhalaj.output.Component;
import bednarhalaj.output.items.EntityMenuItem;
import bednarhalaj.output.items.MenuItem;
import bednarhalaj.output.items.OperationMenuItem;
import bednarhalaj.output.strategy.ListItemsOutputStrategy;


public class ChooseActionState extends State {

    private static ChooseActionState chooseActionStateInstance = null;

    private ChooseActionState(){

    }

    public static ChooseActionState getInstance(){
        if (chooseActionStateInstance == null){
            chooseActionStateInstance = new ChooseActionState();
        }
        return  chooseActionStateInstance;
    }

    @Override
    public Component operation(MenuItem<?> menuItem) {
        State nextState = this;
        Component componentToReturn = getFirstComponent();
        if (menuItem == OperationMenuItem.CREATE) {
            nextState = ChooseEntityToCreateState.getInstance();
            componentToReturn = getNextComponentWithAllDBEntities();
        } else if (menuItem == OperationMenuItem.UPDATE) {
            nextState = ChooseEntityToUpdateState.getInstance();
            componentToReturn = getNextComponentWithAllDBEntities();
        } else if (menuItem == OperationMenuItem.DELETE) {
            nextState = ChooseEntityToDeleteState.getInstance();
            componentToReturn = getNextComponentWithAllDBEntities();
        } else if (menuItem == OperationMenuItem.READ) {
            nextState = ChooseEntityToReadState.getInstance();
            componentToReturn = getNextComponentWithAllDBEntities();
        } else if (menuItem == OperationMenuItem.COMPUTE_COST) {
            nextState = ChooseEntityToComputeCostState.getInstance();
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
