package bednarhalaj.output.strategy;

import bednarhalaj.model.users.db.DBUser;
import bednarhalaj.output.items.LoginMenuItem;


public class PasswordVerifyOutputStrategy extends OutputStrategy {

    private final DBUser dbUser;

    private final String ERROR = "Something went wrong, try again!\n";

    public PasswordVerifyOutputStrategy(DBUser dbUser) {
        this.dbUser = dbUser;
    }

    @Override
    public void execute() {
        try {
            System.out.print("Password: ");
            String input = scanner.nextLine();

            LoginMenuItem loginMenuItem;
            if (input.equals(dbUser.getPassword())) {
                loginMenuItem = LoginMenuItem.PASSWORD_MATCH;
                loginMenuItem.setLabel(dbUser);
            } else {
                loginMenuItem = LoginMenuItem.PASSWORD_MISMATCH;
                System.out.println("Password is incorrect!");
            }
            System.out.println();
            outputMediator.notify(loginMenuItem);
        } catch (Exception e) {
            System.out.println(ERROR);
        }
    }
}






