package bednarhalaj.output.state;

import bednarhalaj.command.Command;
import bednarhalaj.command.ComputeCostCommand;
import bednarhalaj.output.items.HierarchyEntityMenuItem;
import bednarhalaj.output.items.MenuItem;
import bednarhalaj.output.strategy.LineOutputStrategy;
import bednarhalaj.output.strategy.OutputStrategy;
import org.hibernate.query.OutputableType;

import java.math.BigDecimal;

public class ComputeCostState extends State {

    private static ComputeCostState computeCostStateInstance = null;

    private ComputeCostState(){

    }

    public static ComputeCostState getInstance(){
        if (computeCostStateInstance == null){
            computeCostStateInstance = new ComputeCostState();
        }

        return computeCostStateInstance;
    }

    @Override
    public OutputStrategy operation(MenuItem<?> menuItem) {
        State nextState = ChooseActionState.getInstance();
        OutputStrategy outputStrategyToReturn = getFirstOutputStrategy();

        if (menuItem == HierarchyEntityMenuItem.ITEM) {
            HierarchyEntityMenuItem localMenuItem = (HierarchyEntityMenuItem) menuItem;
            Command<BigDecimal> computeCostCommand = new ComputeCostCommand<>(localMenuItem.getLabel());
            BigDecimal cost = computeCostCommand.execute();
            outputStrategyToReturn = new LineOutputStrategy("Total cost: " + cost.toString());
        }
        nextState.setOutputMediator(outputMediator);
        outputMediator.setActualState(nextState);
        return outputStrategyToReturn;
    }
}

