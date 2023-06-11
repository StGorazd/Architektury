package bednarhalaj.output.state;

import bednarhalaj.command.crud.read.ReadAllUsersCommand;
import bednarhalaj.command.crud.read.ReadAllCommand;
import bednarhalaj.model.users.db.DBUser;
import bednarhalaj.output.Manager;
import bednarhalaj.output.items.MenuItem;
import bednarhalaj.output.items.ActionMenuItem;
import bednarhalaj.output.strategy.ListDBEntityOutputStrategy;
import bednarhalaj.output.strategy.ListItemsOutputStrategy;
import bednarhalaj.output.strategy.OutputStrategy;

public abstract class State {

    protected Manager manager;

    protected State nextState;

    protected OutputStrategy outputStrategyToReturn;

    public OutputStrategy handle(MenuItem<?> menuItem) {
        setDefaults(menuItem);
        processMenuItem(menuItem);
        setUpManager();
        return outputStrategyToReturn;
    }

    protected void setDefaults(MenuItem<?> menuItem) {
        nextState = ChooseActionState.getInstance();
        outputStrategyToReturn = getFirstOutputStrategy();
    }

    abstract protected void processMenuItem(MenuItem<?> menuItem);

    protected void setUpManager() {
        nextState.setManager(manager);
        manager.setActualState(nextState);
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    protected OutputStrategy getFirstOutputStrategy() {
        return new ListItemsOutputStrategy(
                ActionMenuItem.CREATE,
                ActionMenuItem.UPDATE,
                ActionMenuItem.READ,
                ActionMenuItem.DELETE,
                ActionMenuItem.COMPUTE_COST,
                ActionMenuItem.EXIT);
    }

    public OutputStrategy getLoginOutputStrategy() {
        ReadAllCommand<DBUser> readAllCommand = new ReadAllUsersCommand();
        return new ListDBEntityOutputStrategy(readAllCommand.execute(), true, "Select your account:");
    }
}
