package bednarhalaj.output.state;

import bednarhalaj.command.crud.read.ReadAllUsersCommand;
import bednarhalaj.command.crud.read.ReadCommand;
import bednarhalaj.model.users.db.DBUser;
import bednarhalaj.output.OutputMediator;
import bednarhalaj.output.items.MenuItem;
import bednarhalaj.output.items.OperationMenuItem;
import bednarhalaj.output.strategy.ListDBEntityOutputStrategy;
import bednarhalaj.output.strategy.ListItemsOutputStrategy;
import bednarhalaj.output.strategy.OutputStrategy;

public abstract class State {

    protected OutputMediator outputMediator;

    public abstract OutputStrategy operation(MenuItem<?> menuItem);

    public void setOutputMediator(OutputMediator outputMediator) {
        this.outputMediator = outputMediator;
    }

    public OutputStrategy getFirstOutputStrategy() {
        return new ListItemsOutputStrategy(
                OperationMenuItem.CREATE,
                OperationMenuItem.UPDATE,
                OperationMenuItem.READ,
                OperationMenuItem.DELETE,
                OperationMenuItem.COMPUTE_COST,
                OperationMenuItem.EXIT);
    }

    public OutputStrategy getLoginOutputStrategy() {
        ReadCommand<DBUser> readCommand = new ReadAllUsersCommand();
        return new ListDBEntityOutputStrategy(readCommand.execute(), true, "Select your account:");
    }
}
