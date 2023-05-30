package bednarhalaj.output;

import bednarhalaj.command.ComputeCostCommand;
import bednarhalaj.command.crud.create.*;
import bednarhalaj.command.crud.delete.DeleteCommand;
import bednarhalaj.command.crud.read.*;
import bednarhalaj.command.crud.update.UpdateCommand;
import bednarhalaj.model.DBEntity;
import bednarhalaj.model.hierarchy.*;
import bednarhalaj.output.items.EntityMenuItem;
import bednarhalaj.output.items.MenuItem;
import bednarhalaj.output.items.OperationMenuItem;
import bednarhalaj.output.state.ChooseActionState;
import bednarhalaj.output.state.State;
import bednarhalaj.output.strategy.ListItemsOutputStrategy;

import java.util.HashMap;
import java.util.Map;

public class OutputMediator {
    private State actualState;

    public OutputMediator() {
        actualState = new ChooseActionState();
        actualState.setOutputMediator(this);
    }


    public void notify(MenuItem<?> menuItem) {
        Component nextComponent = actualState.operation(menuItem);
        register(nextComponent);
    }

    public void register(Component component) {
        component.setMediator(this);
        component.execute();
    }

    public void start() {
        Component component = actualState.getFirstComponent();
        register(component);
    }

    public void setActualState(State actualState) {
        this.actualState = actualState;
    }
}
