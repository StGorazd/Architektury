package bednarhalaj.output.state;

import bednarhalaj.model.users.db.DBUser;
import bednarhalaj.output.items.LoginMenuItem;
import bednarhalaj.output.items.MenuItem;
import bednarhalaj.output.strategy.OutputStrategy;

public class PasswordVerifyState extends State {
    private static PasswordVerifyState passwordVerifyStateInstance = null;

    public static PasswordVerifyState getInstance() {
        if (passwordVerifyStateInstance == null) {
            passwordVerifyStateInstance = new PasswordVerifyState();
        }

        return passwordVerifyStateInstance;
    }

    @Override
    public OutputStrategy operation(MenuItem<?> menuItem) {
        State nextState = ChooseActionState.getInstance();
        OutputStrategy outputStrategyToReturn = getFirstOutputStrategy();

        if (menuItem == LoginMenuItem.PASSWORD_MISMATCH) {
            nextState = LoginState.getInstance();
            outputStrategyToReturn = getLoginOutputStrategy();
        } else {
            outputMediator.setUser((DBUser) menuItem.getLabel());
        }

        nextState.setOutputMediator(outputMediator);
        outputMediator.setActualState(nextState);
        return outputStrategyToReturn;

    }
}
