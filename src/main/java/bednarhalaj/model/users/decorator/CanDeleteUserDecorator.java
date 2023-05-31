package bednarhalaj.model.users.decorator;

import bednarhalaj.model.users.User;

public class CanDeleteUserDecorator extends UserDecorator {
    public CanDeleteUserDecorator(User user) {
        super(user);
    }
    @Override
    public boolean canDelete() {
        return true;
    }
}
