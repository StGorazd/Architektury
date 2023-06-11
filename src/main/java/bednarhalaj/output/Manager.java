package bednarhalaj.output;

import bednarhalaj.model.users.DatabaseUserFactory;
import bednarhalaj.model.users.User;
import bednarhalaj.model.users.db.DBUser;
import bednarhalaj.output.items.MenuItem;
import bednarhalaj.output.state.LoginState;
import bednarhalaj.output.state.State;
import bednarhalaj.output.strategy.OutputStrategy;

public class Manager {
    private State actualState;
    private static User user;

    public Manager() {
        actualState = LoginState.getInstance();
        actualState.setManager(this);
    }


    public void process(MenuItem<?> menuItem) {
        OutputStrategy nextStrategy = actualState.handle(menuItem);
        executeStrategy(nextStrategy);
    }

    public void executeStrategy(OutputStrategy strategy) {
        strategy.setManager(this);
        strategy.execute();
    }

    public void start() {
        OutputStrategy strategy = actualState.getLoginOutputStrategy();
        executeStrategy(strategy);
    }

    public void setUser(DBUser dbUser) {
        DatabaseUserFactory databaseUserFactory = new DatabaseUserFactory();
        user = databaseUserFactory.getDatabaseUser(dbUser.getRole());
    }

    public static User getUser() {
        return user;
    }

    public void setActualState(State actualState) {
        this.actualState = actualState;
    }
}
