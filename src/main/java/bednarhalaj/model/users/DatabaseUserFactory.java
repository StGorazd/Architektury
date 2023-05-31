package bednarhalaj.model.users;

import bednarhalaj.model.users.db.Role;
import bednarhalaj.model.users.decorator.CanDeleteUserDecorator;
import bednarhalaj.model.users.decorator.CanReadUserDecorator;
import bednarhalaj.model.users.decorator.CanUpdateUserDecorator;
import bednarhalaj.model.users.decorator.CanWriteUserDecorator;

public class DatabaseUserFactory {

    public User getDatabaseUser(Role role) {
        User databaseUser = new DatabaseUser();
        if (role == Role.TESTER) {
            return databaseUser;
        }
        databaseUser = new CanReadUserDecorator(databaseUser);
        if (role == Role.VIEWER) {
            return databaseUser;
        }
        databaseUser = new CanWriteUserDecorator(databaseUser);
        databaseUser = new CanUpdateUserDecorator(databaseUser);

        if (role == Role.EDITOR) {
            return databaseUser;
        }
        databaseUser = new CanDeleteUserDecorator(databaseUser);

        return databaseUser;

    }
}
