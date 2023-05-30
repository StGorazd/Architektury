package bednarhalaj.output.state;

import bednarhalaj.output.Component;
import bednarhalaj.output.OutputMediator;
import bednarhalaj.output.items.MenuItem;
import bednarhalaj.output.items.OperationMenuItem;
import bednarhalaj.output.strategy.ListItemsOutputStrategy;

public abstract class State {

    protected OutputMediator outputMediator;

    public abstract Component operation(MenuItem<?> menuItem);

    public void setOutputMediator(OutputMediator outputMediator) {
        this.outputMediator = outputMediator;
    }

    public Component getFirstComponent() {
        return new ListItemsOutputStrategy(
                OperationMenuItem.CREATE,
                OperationMenuItem.UPDATE,
                OperationMenuItem.READ,
                OperationMenuItem.DELETE,
                OperationMenuItem.COMPUTE_COST,
                OperationMenuItem.EXIT);
    }
}
