package bednarhalaj.output.state;

import bednarhalaj.output.items.EntityMenuItem;
import bednarhalaj.output.items.MenuItem;
import bednarhalaj.output.items.ActionMenuItem;
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
        if (menuItem == ActionMenuItem.CREATE) {
            nextState = ChooseEntityToCreateState.getInstance();
            outputStrategyToReturn = getNextOutputStrategyWithAllDBEntities();
        } else if (menuItem == ActionMenuItem.UPDATE) {
            nextState = ChooseEntityToUpdateState.getInstance();
            outputStrategyToReturn = getNextOutputStrategyWithAllDBEntities();
        } else if (menuItem == ActionMenuItem.DELETE) {
            nextState = ChooseEntityToDeleteState.getInstance();
            outputStrategyToReturn = getNextOutputStrategyWithAllDBEntities();
        } else if (menuItem == ActionMenuItem.READ) {
            nextState = ChooseEntityToReadState.getInstance();
            outputStrategyToReturn = getNextOutputStrategyWithAllDBEntities();
        } else if (menuItem == ActionMenuItem.COMPUTE_COST) {
            nextState = ChooseEntityToComputeCostState.getInstance();
            outputStrategyToReturn = getNextOutputStrategyWithHierarchyEntities();
        } else if (menuItem == ActionMenuItem.EXIT) {
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
                ActionMenuItem.BACK);
    }

    private OutputStrategy getNextOutputStrategyWithHierarchyEntities() {
        return new ListItemsOutputStrategy(EntityMenuItem.EMPLOYEE,
                EntityMenuItem.TEAM,
                EntityMenuItem.DEPARTMENT,
                EntityMenuItem.COMPANY,
                ActionMenuItem.BACK);
    }
}
