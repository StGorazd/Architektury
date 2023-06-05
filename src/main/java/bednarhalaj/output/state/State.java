package bednarhalaj.output.state;

import bednarhalaj.command.crud.read.ReadAllUsersCommand;
import bednarhalaj.command.crud.read.ReadAllCommand;
import bednarhalaj.model.users.db.DBUser;
import bednarhalaj.output.OutputMediator;
import bednarhalaj.output.items.MenuItem;
import bednarhalaj.output.items.ActionMenuItem;
import bednarhalaj.output.strategy.ListDBEntityOutputStrategy;
import bednarhalaj.output.strategy.ListItemsOutputStrategy;
import bednarhalaj.output.strategy.OutputStrategy;

public abstract class State {

    protected OutputMediator outputMediator;

    public abstract OutputStrategy operation(MenuItem<?> menuItem);

    public void setOutputMediator(OutputMediator outputMediator) {
        this.outputMediator = outputMediator;
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
