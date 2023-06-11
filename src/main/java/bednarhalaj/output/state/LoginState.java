package bednarhalaj.output.state;

import bednarhalaj.model.users.db.DBUser;
import bednarhalaj.output.items.MenuItem;
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
    protected void processMenuItem(MenuItem<?> menuItem) {

    }

    @Override
    protected  void setDefaults(MenuItem<?> menuItem){
        nextState = PasswordVerifyState.getInstance();
        outputStrategyToReturn = new PasswordVerifyOutputStrategy((DBUser) menuItem.getLabel());
    }
}
