package bednarhalaj.output.state;

import bednarhalaj.output.items.EntityMenuItem;
import bednarhalaj.output.items.MenuItem;
import bednarhalaj.output.items.OperationMenuItem;
import bednarhalaj.output.strategy.ListItemsOutputStrategy;
import bednarhalaj.output.strategy.OutputStrategy;


public class ChooseActionState extends State {

    private static ChooseActionState chooseActionStateInstance = null;
    public static ChooseActionState getInstance(){
        if (chooseActionStateInstance == null){
            chooseActionStateInstance = new ChooseActionState();
        }
        return  chooseActionStateInstance;
    }

    @Override
    public OutputStrategy operation(MenuItem<?> menuItem) {
        State nextState = this;
        OutputStrategy outputStrategyToReturn = getFirstOutputStrategy();
        if (menuItem == OperationMenuItem.CREATE) {
            nextState = ChooseEntityToCreateState.getInstance();
            outputStrategyToReturn = getNextOutputStrategyWithAllDBEntities();
        } else if (menuItem == OperationMenuItem.UPDATE) {
            nextState = ChooseEntityToUpdateState.getInstance();
            outputStrategyToReturn = getNextOutputStrategyWithAllDBEntities();
        } else if (menuItem == OperationMenuItem.DELETE) {
            nextState = ChooseEntityToDeleteState.getInstance();
            outputStrategyToReturn = getNextOutputStrategyWithAllDBEntities();
        } else if (menuItem == OperationMenuItem.READ) {
            nextState = ChooseEntityToReadState.getInstance();
            outputStrategyToReturn = getNextOutputStrategyWithAllDBEntities();
        } else if (menuItem == OperationMenuItem.COMPUTE_COST) {
            nextState = ChooseEntityToComputeCostState.getInstance();
            outputStrategyToReturn = getNextOutputStrategyWithHierarchyEntities();
        } else if (menuItem == OperationMenuItem.EXIT) {
            System.exit(0);
        }

        nextState.setOutputMediator(outputMediator);
        outputMediator.setActualState(nextState);
        return outputStrategyToReturn;
    }

    private OutputStrategy getNextOutputStrategyWithAllDBEntities() {
        return new ListItemsOutputStrategy(EntityMenuItem.EMPLOYEE,
                EntityMenuItem.TEAM,
                EntityMenuItem.DEPARTMENT,
                EntityMenuItem.COMPANY,
                EntityMenuItem.POSITION,
                OperationMenuItem.BACK);
    }

    private OutputStrategy getNextOutputStrategyWithHierarchyEntities() {
        return new ListItemsOutputStrategy(EntityMenuItem.EMPLOYEE,
                EntityMenuItem.TEAM,
                EntityMenuItem.DEPARTMENT,
                EntityMenuItem.COMPANY,
                OperationMenuItem.BACK);
    }
}
