package bednarhalaj.output.state;

import bednarhalaj.model.users.db.DBUser;
import bednarhalaj.output.items.LoginMenuItem;
import bednarhalaj.output.items.MenuItem;

public class PasswordVerifyState extends State {
    private static PasswordVerifyState passwordVerifyStateInstance = null;

    public static PasswordVerifyState getInstance() {
        if (passwordVerifyStateInstance == null) {
            passwordVerifyStateInstance = new PasswordVerifyState();
        }

        return passwordVerifyStateInstance;
    }

    @Override
    protected void processMenuItem(MenuItem<?> menuItem) {
        if (menuItem == LoginMenuItem.PASSWORD_MISMATCH) {
            nextState = LoginState.getInstance();
            outputStrategyToReturn = getLoginOutputStrategy();
        } else {
            manager.setUser((DBUser) menuItem.getLabel());
        }
    }
}
