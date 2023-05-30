package bednarhalaj.output.state;

import bednarhalaj.command.Command;
import bednarhalaj.command.ComputeCostCommand;
import bednarhalaj.output.Component;
import bednarhalaj.output.items.HierarchyEntityMenuItem;
import bednarhalaj.output.items.MenuItem;
import bednarhalaj.output.strategy.LineOutputStrategy;

import java.math.BigDecimal;

public class ComputeCostState extends State {
    @Override
    public Component operation(MenuItem<?> menuItem) {
        State nextState = new ChooseActionState();
        Component componentToReturn = getFirstComponent();

        if (menuItem == HierarchyEntityMenuItem.ITEM) {
            HierarchyEntityMenuItem localMenuItem = (HierarchyEntityMenuItem) menuItem;
            Command<BigDecimal> computeCostCommand = new ComputeCostCommand<>(localMenuItem.getLabel());
            BigDecimal cost = computeCostCommand.execute();
            componentToReturn = new LineOutputStrategy("Total cost: " + cost.toString());
        }
        nextState.setOutputMediator(outputMediator);
        outputMediator.setActualState(nextState);
        return componentToReturn;
    }
}

