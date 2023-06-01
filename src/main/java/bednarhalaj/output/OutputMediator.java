package bednarhalaj.output;

import bednarhalaj.model.users.DatabaseUserFactory;
import bednarhalaj.model.users.User;
import bednarhalaj.model.users.db.DBUser;
import bednarhalaj.output.items.MenuItem;
import bednarhalaj.output.state.LoginState;
import bednarhalaj.output.state.State;
import bednarhalaj.output.strategy.OutputStrategy;

public class OutputMediator {
    private State actualState;

    private static User user;

    public OutputMediator() {
        actualState = LoginState.getInstance();
        actualState.setOutputMediator(this);
    }


    public void notify(MenuItem<?> menuItem) {
        OutputStrategy nextStrategy = actualState.operation(menuItem);
        register(nextStrategy);
    }

    public void register(OutputStrategy strategy) {
        strategy.setMediator(this);
        strategy.execute();
    }

    public void start() {
        OutputStrategy strategy = actualState.getLoginOutputStrategy();
        register(strategy);
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
