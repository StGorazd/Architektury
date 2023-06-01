package bednarhalaj.output.state;

import bednarhalaj.model.users.db.DBUser;
import bednarhalaj.output.items.MenuItem;
import bednarhalaj.output.strategy.OutputStrategy;
import bednarhalaj.output.strategy.PasswordVerifyOutputStrategy;


public class LoginState extends State {

    private static LoginState loginStateInstance = null;

    public static LoginState getInstance() {
        if (loginStateInstance == null) {
            loginStateInstance = new LoginState();
        }

        return loginStateInstance;
    }

    @Override
    public OutputStrategy operation(MenuItem<?> menuItem) {

        State nextState = PasswordVerifyState.getInstance();

        OutputStrategy outputStrategyToReturn = new PasswordVerifyOutputStrategy((DBUser) menuItem.getLabel());

        nextState.setOutputMediator(outputMediator);
        outputMediator.setActualState(nextState);

        return outputStrategyToReturn;

    }
}
